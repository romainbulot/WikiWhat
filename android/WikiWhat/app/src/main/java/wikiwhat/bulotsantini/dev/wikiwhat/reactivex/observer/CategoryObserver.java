package wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer;

import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;

/**
 * Created by Administrator on 12/03/2017.
 */

public class CategoryObserver implements Observer<String> {
    private TextView textView;
    private Category category;
    private String errorMessage;

    public CategoryObserver(TextView textView, String errorMessage) {
        this.textView = textView;
        this.errorMessage = errorMessage;
    }

    @Override
    public void onSubscribe(Disposable d) {
        // TODO mettre un petit spinner de chargement
    }

    @Override
    public void onNext(String value) {
        // TODO parser le JSON et tester si c'est une catégorie qui en est sortie
        // ou l'ensemble des pages de la catéfories

    }

    @Override
    public void onError(Throwable e) {
        textView.setText(errorMessage);
    }

    @Override
    public void onComplete() {
        textView.setText(category.toString());
    }
}
