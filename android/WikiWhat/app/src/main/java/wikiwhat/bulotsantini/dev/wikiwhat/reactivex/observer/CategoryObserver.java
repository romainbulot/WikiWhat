package wikiwhat.bulotsantini.dev.wikiwhat.reactivex.observer;

import android.util.Log;
import android.widget.TextView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.MainPresenter;

/**
 * Created by Administrator on 12/03/2017.
 */

public class CategoryObserver implements Observer<Category> {
    private MainPresenter presenter;
    private TextView textView;
    private Category category;
    private String errorMessage;

    public CategoryObserver(MainPresenter presenter, TextView textView, Category cat, String errorMessage) {
        this.presenter = presenter;
        this.textView = textView;
        this.category = cat;
        this.errorMessage = errorMessage;
    }

    @Override
    public void onSubscribe(Disposable d) {
        textView.setText(presenter.getView().getResources().getString(R.string.loading));
    }

    @Override
    public void onNext(Category value) {
        category.setId(value.getId());
        category.setNb_pages(value.getNb_pages());
        category.setName(value.getName());
    }

    @Override
    public void onError(Throwable e) {
        Log.d("Error", e.getMessage());
        // textView.setText(e.toString());
        // textView.setText(errorMessage);
    }

    @Override
    public void onComplete() {
        Log.d("on complete",category.toString());
        textView.setText(category.toString());
    }
}
