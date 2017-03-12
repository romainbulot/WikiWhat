package wikiwhat.bulotsantini.dev.wikiwhat.presenter;

import java.util.concurrent.Executor;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer.CategoryObserver;
import wikiwhat.bulotsantini.dev.wikiwhat.view.MainActivity;

/**
 * Created by Administrator on 07/03/2017.
 */

public class MainPresenter {
    private MainActivity view;
    private Observer<String> cat1_observer;
    private Observer<String> cat2_observer;
    private Observer<String> cat3_observer;
    public static final String url = "https://en.wikipedia.org/w/api.php?action=query&list=random&prop=categories&rnnamespace=14";

    public MainPresenter(MainActivity v) {
        view = v;
        cat1_observer = new CategoryObserver(view.getmCat1(), view.getResources().getString(R.string.err_loading_cat));
        cat2_observer = new CategoryObserver(view.getmCat2(), view.getResources().getString(R.string.err_loading_cat));
        cat3_observer = new CategoryObserver(view.getmCat3(), view.getResources().getString(R.string.err_loading_cat));
    }

    public void refresh(int i) {
        Observer<String> observer;

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

        // Subscribe the observer
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {



                e.onComplete();
            }
        });
    }

    public void refreshAll() {
        refresh(1);
        refresh(2);
        refresh(3);
    }
}
