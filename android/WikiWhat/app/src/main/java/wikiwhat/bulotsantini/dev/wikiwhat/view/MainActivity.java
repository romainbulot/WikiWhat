package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity {

    private MainPresenter mPresenter;

    // UI Elements
    private Button mRefresh1;
    private Button mRefresh2;
    private Button mRefresh3;
    private Button mRefreshAll;
    private Button mPlay;

    private TextView mCat1;
    private TextView mCat2;
    private TextView mCat3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCat1 = (TextView) findViewById(R.id.text_cat1);
        mCat2 = (TextView) findViewById(R.id.text_cat2);
        mCat3 = (TextView) findViewById(R.id.text_cat3);

        mRefresh1 = (Button) findViewById(R.id.buttonRafraichir1);
        mRefresh2 = (Button) findViewById(R.id.buttonRafraichir2);
        mRefresh3 = (Button) findViewById(R.id.buttonRafraichir3);
        mRefreshAll = (Button) findViewById(R.id.buttonToutRafraichir);
        mPlay = (Button) findViewById(R.id.buttonJouer);
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

    public void DisplayGame(View view) {
        Intent intent = new Intent(MainActivity.this, JeuActivity.class);
        startActivity(intent);
    }

}
