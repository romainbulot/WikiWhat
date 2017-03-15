package wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.JeuPresenter;

/**
 * Created by Administrator on 15/03/2017.
 */

public class HintObserver implements Observer<String> {
    private JeuPresenter presenter;
    private String hint;

    public HintObserver(JeuPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onSubscribe(Disposable d) {
        // Nothing to do
    }

    @Override
    public void onNext(String value) {
        hint = value;
    }

    @Override
    public void onError(Throwable e) {
        // TODO trouver un moyen de gérer l'erreur
        Log.d("Hint loading error", "Error");
    }

    @Override
    public void onComplete() {
        presenter.getGame().getHints().add(hint);
        presenter.getView().getHints().add(hint);

        presenter.getView().getHints().clear();

        for (String hint : presenter.getGame().getHints()) {
            presenter.getView().getHints().add(hint);
        }

        presenter.getView().getHintAdapter().notifyDataSetChanged();
    }
}
