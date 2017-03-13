package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
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

        // Set UI elements
        mCat1 = (TextView) findViewById(R.id.text_cat1);
        mCat2 = (TextView) findViewById(R.id.text_cat2);
        mCat3 = (TextView) findViewById(R.id.text_cat3);

        mRefresh1 = (Button) findViewById(R.id.buttonRafraichir1);
        mRefresh2 = (Button) findViewById(R.id.buttonRafraichir2);
        mRefresh3 = (Button) findViewById(R.id.buttonRafraichir3);
        mRefreshAll = (Button) findViewById(R.id.buttonToutRafraichir);
        mPlay = (Button) findViewById(R.id.buttonJouer);

        // Set presenter
        mPresenter = new MainPresenter(this);

        // Set event listener
        mRefresh1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.refresh(1);
                Log.d("Bouton 1", "Presenter ready!");
            }
        });
        mRefresh2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.refresh(2);
                Log.d("Bouton 2", "Presenter ready!");
            }
        });
        mRefresh3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.refresh(3);
                Log.d("Bouton 3", "Presenter ready!");
            }
        });
        mRefreshAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.refreshAll();
            }
        });
        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayGame();
            }
        });

        mRefreshAll.performClick();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void displayGame() {
        Intent intent = new Intent(MainActivity.this, JeuActivity.class);
        //intent.putExtra("category1", mPresenter.getCat1());
        //intent.putExtra("category2", mPresenter.getCat2());
        //intent.putExtra("category3", mPresenter.getCat3());
        startActivity(intent);
    }

    public Button getmRefresh1() {
        return mRefresh1;
    }

    public Button getmRefresh2() {
        return mRefresh2;
    }

    public Button getmRefresh3() {
        return mRefresh3;
    }

    public Button getmRefreshAll() {
        return mRefreshAll;
    }

    public Button getmPlay() {
        return mPlay;
    }

    public TextView getmCat1() {
        return mCat1;
    }

    public TextView getmCat2() {
        return mCat2;
    }

    public TextView getmCat3() {
        return mCat3;
    }
}
