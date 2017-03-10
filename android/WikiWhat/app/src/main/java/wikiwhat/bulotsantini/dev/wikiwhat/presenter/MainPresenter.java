package wikiwhat.bulotsantini.dev.wikiwhat.presenter;

import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import wikiwhat.bulotsantini.dev.wikiwhat.view.MainActivity;

/**
 * Created by Administrator on 07/03/2017.
 */

public class MainPresenter implements SingleObserver<String>{
    private MainActivity view;

    public MainPresenter(MainActivity v) {
        view = v;
    }

    @Override
    public void onSubscribe(Disposable d) {
        
    }

    @Override
    public void onSuccess(String value) {

    }

    @Override
    public void onError(Throwable e) {

    }
}
