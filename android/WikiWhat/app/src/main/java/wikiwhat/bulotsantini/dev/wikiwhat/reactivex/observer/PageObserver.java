package wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Game;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Page;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.JeuPresenter;

/**
 * Created by Administrator on 14/03/2017.
 */

public class PageObserver implements Observer<Page> {
    /**
     * Presenter using the observer
     */
    private JeuPresenter presenter;
    /**
     * Page to get
     */
    private Page page;
    /**
     * Categories where the page need to be found
     */
    private Category[] categories;

    public PageObserver(JeuPresenter presenter, Category[] categories) {
        this.presenter = presenter;
        this.categories = categories;
    }

    @Override
    public void onSubscribe(Disposable d) {
        // Do nothing
    }

    @Override
    public void onNext(Page value) {
        page = value;
    }

    @Override
    public void onError(Throwable e) {
        // TODO trouver un moyen de gérer une erreur de chargement
        Log.d("Loading page error", "Error during loading the page");
    }

    @Override
    public void onComplete() {
        presenter.setGame(new Game(categories, page));
        presenter.addHint();
    }
}
