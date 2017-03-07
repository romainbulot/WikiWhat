package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    public void AfficherJeu(View view)
    {
        Intent intent = new Intent(MainActivity.this, JeuActivity.class);
        startActivity(intent);
    }

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }





    @Override
    protected void onStart() {
        super.onStart();

        refreshAll();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    private void refresh() {

    }

    private void refreshAll() {

    }
}
