package wikiwhat.bulotsantini.dev.wikiwhat.presenter;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Game;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Page;
import wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer.HintObserver;
import wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer.PageObserver;
import wikiwhat.bulotsantini.dev.wikiwhat.utils.JsonRequest;
import wikiwhat.bulotsantini.dev.wikiwhat.view.JeuActivity;

/**
 * Created by Administrator on 14/03/2017.
 */

public class JeuPresenter {
    private JeuActivity view;
    private PageObserver pageObserver;
    private HintObserver hintObserver;
    private Game game;
    private final String url_page = "https://fr.wikipedia.org/w/api.php?action=query&list=categorymembers&format=json&cmpageid=";
    private final String url_hint = "https://fr.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&explaintext=&pageids=";

    public JeuPresenter(JeuActivity view, Category[] categories) {
        this.view = view;
        this.pageObserver = new PageObserver(this, categories);
        this.hintObserver = new HintObserver(this);
        initGameFromCategories(categories);
    }

    private void initGameFromCategories(final Category[] categories) {
        Observable<Page> observablePage = Observable.create(new ObservableOnSubscribe<Page>() {
            @Override
            public void subscribe(final ObservableEmitter<Page> e) throws Exception {
                Executors.newCachedThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<Page> pages = new ArrayList<Page>();
                        Random rand = new Random();

                        try {
                            // Get all the pages of the categories
                            for (Category cat : categories) {
                                String json_page = JsonRequest.getFromUrl(url_page + cat.getId());
                                Log.d("JSON PAGE", json_page);
                                JSONObject obj = new JSONObject(json_page);
                                JSONArray array = obj.getJSONObject("query").getJSONArray("categorymembers");
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject page_obj = array.getJSONObject(i);
                                    pages.add(new Page(page_obj.getInt("pageid"), page_obj.getString("title")));
                                }
                            }

                            // Get random page
                            int page_number = rand.nextInt(pages.size());

                            // Emit it
                            e.onNext(pages.get(page_number));

                            // Complete
                            e.onComplete();
                        } catch (Exception exception) {
                            e.onError(exception);
                        }
                    }
                });
            }
        });

        observablePage.observeOn(AndroidSchedulers.mainThread()).subscribe(pageObserver);
    }

    private String extract(String extract) {
        String[] array = extract.replace("\n","").split("\\.");
        String[] words_answer = game.getCurrent_page().getName().split(" ");

        Random rand = new Random();

        String res = array[rand.nextInt(array.length)];

        for (String word : words_answer) {
            res.replace(word, "XXX");
        }

        for (int i = 0; i < 10; i++) {
            res.replace("XXX XXX", "XXX");
        }

        return res;
    }

    public void addHint() {
        Observable<String> observablePage = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(final ObservableEmitter<String> e) throws Exception {
                Executors.newCachedThreadPool().execute(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            String page_json = JsonRequest.getFromUrl(url_hint + game.getCurrent_page().getId());
                            Log.d("HINT JSON",page_json);
                            JSONObject obj = new JSONObject(page_json);
                            String extract = obj.getJSONObject("query").getJSONObject("pages").getJSONObject(game.getCurrent_page().getId() + "").getString("extract");

                            // Get a random sentence from the extract

                            // Emit the hint
                            e.onNext(extract(extract));

                            // Complete
                            e.onComplete();
                        } catch (Exception exception) {
                            e.onError(exception);
                        }
                    }
                });
            }
        });

        observablePage.observeOn(AndroidSchedulers.mainThread()).subscribe(hintObserver);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game g) {
        game = g;
    }

    public JeuActivity getView() {
        return view;
    }

    public void updateListView() {

    }
}
