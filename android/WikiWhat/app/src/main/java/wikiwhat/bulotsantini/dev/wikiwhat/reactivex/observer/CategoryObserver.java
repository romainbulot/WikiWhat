package wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer;

import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;

/**
 * Created by Administrator on 12/03/2017.
 */

public class CategoryObserver implements Observer<Category> {
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
    public void onNext(Category value) {
        category = value;
    }

    @Override
    public void onError(Throwable e) {
        Log.d("Error", e.getMessage());
        // textView.setText(e.toString());
        // textView.setText(errorMessage);
    }

    @Override
    public void onComplete() {
        textView.setText(category.toString());
    }
}
