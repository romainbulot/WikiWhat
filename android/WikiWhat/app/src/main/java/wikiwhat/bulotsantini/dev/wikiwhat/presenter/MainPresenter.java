package wikiwhat.bulotsantini.dev.wikiwhat.presenter;

import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;
import wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer.CategoryObserver;
import wikiwhat.bulotsantini.dev.wikiwhat.utils.JsonRequest;
import wikiwhat.bulotsantini.dev.wikiwhat.view.MainActivity;

/**
 * Created by Administrator on 07/03/2017.
 */

public class MainPresenter {
    private MainActivity view;
    private Observer<Category> cat1_observer;
    private Category cat1;
    private Observer<Category> cat2_observer;
    private Category cat2;
    private Observer<Category> cat3_observer;
    private Category cat3;
    public static final String url_cat = "https://fr.wikipedia.org/w/api.php?action=query&list=random&prop=categories&rnnamespace=14&format=json";
    public static final String url_nb_pages = "https://fr.wikipedia.org/w/api.php?action=query&list=categorymembers&format=json&cmpageid=";

    public MainPresenter(MainActivity v) {
        view = v;
        cat1 = new Category();
        cat2 = new Category();
        cat3 = new Category();
        cat1_observer = new CategoryObserver(this, view.getmCat1(), cat1, view.getResources().getString(R.string.err_loading_cat));
        cat2_observer = new CategoryObserver(this, view.getmCat2(), cat2, view.getResources().getString(R.string.err_loading_cat));
        cat3_observer = new CategoryObserver(this, view.getmCat3(), cat3, view.getResources().getString(R.string.err_loading_cat));
    }

    public void refresh(int i) {
        Observer<Category> observer = null;

        // Select the observer to subscribe
        switch (i) {
            case 1:
                observer = cat1_observer;
                break;
            case 2:
                observer = cat2_observer;
                break;
            case 3:
                observer = cat3_observer;
                break;
            default:
                break;
        }

        if (observer != null) {
            // Subscribe the observer
            Observable<Category> observable = Observable.create(new ObservableOnSubscribe<Category>() {
                @Override
                public void subscribe(final ObservableEmitter<Category> e) throws Exception {
                    Executors.newCachedThreadPool().execute(new Runnable() {

                        @Override
                        public void run() {
                            try {
                                // Get the JSON from the url
                                String json_rand_cat = JsonRequest.getFromUrl(url_cat);
                                JSONObject obj = new JSONObject(json_rand_cat);
                                int id = obj.getJSONObject("query").getJSONArray("random").getJSONObject(0).getInt("id");
                                String name = obj.getJSONObject("query").getJSONArray("random").getJSONObject(0).getString("title");

                                String json_nb_page = JsonRequest.getFromUrl(url_nb_pages + id);
                                JSONObject obj2 = new JSONObject(json_nb_page);
                                int nb_pages = obj2.getJSONObject("query").getJSONArray("categorymembers").length();

                                e.onNext(new Category(id, name, nb_pages));

                                e.onComplete();
                            } catch (Exception exception) {
                                e.onError(exception);
                            }
                        }
                    });
                }
            });

            observable.observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
        }

    }

    public void refreshAll() {
        refresh(1);
        refresh(2);
        refresh(3);
    }

    public Category getCat1() {
        return cat1;
    }

    public Category getCat2() {
        return cat2;
    }

    public Category getCat3() {
        return cat3;
    }

    public MainActivity getView() {
        return view;
    }
}
