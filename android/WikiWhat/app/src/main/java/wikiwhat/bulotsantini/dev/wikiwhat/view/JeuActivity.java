package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import wikiwhat.bulotsantini.dev.wikiwhat.R;
import wikiwhat.bulotsantini.dev.wikiwhat.model.Category;
import wikiwhat.bulotsantini.dev.wikiwhat.presenter.JeuPresenter;

/**
 * Created by romain on 07/03/2017.
 */

public class JeuActivity  extends AppCompatActivity {

    /**
     * Presenter
     */
    private JeuPresenter mPresenter;
    /**
     * EditText where the answer of the user will be put
     */
    private EditText mGuess;
    /**
     * Button to validate the choice of the player
     */
    private Button mValideGuess;
    /**
     * TextView containing a hint about the validation of the answer
     */
    private TextView mResult;
    /**
     * ListView displaying the hints
     */
    private ListView mListView;
    /**
     * The content of the previous ListView
     */
    private List<String> hints = new ArrayList<>();
    /**
     * The adapter of the previous ListView
     */
    private ArrayAdapter<String> hintAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getResources().getString(R.string.title_game));
        setContentView(R.layout.activity_jeu);

        // Get categories from the previous activity
        Category[] categories = new Category[3];
        categories[0] = (Category) getIntent().getSerializableExtra("category1");
        categories[1] = (Category) getIntent().getSerializableExtra("category2");
        categories[2] = (Category) getIntent().getSerializableExtra("category3");

        // Set UI elements
        mGuess = (EditText) findViewById(R.id.editText);
        mValideGuess = (Button) findViewById(R.id.buttonValidInput);
        mResult = (TextView) findViewById(R.id.textResultat);
        mListView = (ListView) findViewById(R.id.listView);
        mValideGuess = (Button) findViewById(R.id.buttonValidInput);
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        // Set the list adapter for the list view
        hintAdapter = new ArrayAdapter<String>(JeuActivity.this,
                android.R.layout.simple_list_item_1, hints);
        mListView.setAdapter(hintAdapter);

        // Set the onclicklistener of the button validate
        mValideGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAnswer();
            }
        });

        // Set presenter
        mPresenter = new JeuPresenter(this, categories);

        // Set the first hint
        mPresenter.addHint();
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    /**
     * Format the string to be compare later with another
     * @param str
     * @return
     */
    private String formatString(String str) {
        return str.toLowerCase().replace("é","e").replace("è","e").replace("ô","o").replace("ê","e").replace("à","a").replace("ù","u").replace("î","i");
    }

    /**
     * Check if the answer is well
     * @return true if the answer is well
     */
    private boolean checkAnswer() {
        String guess = formatString(mGuess.getText().toString());
        String answer = formatString(mPresenter.getGame().getCurrent_page().getName());


        return guess.equals(answer);
    }

    /**
     * Validate the formula
     */
    private void validateAnswer() {
        if (checkAnswer()) {
            mResult.setText(getResources().getString(R.string.result_good_1) + " " + mPresenter.getGame().getScore() + " " + getResources().getString(R.string.result_good_2));
            setButtonForPlayAgain();
        } else {
            if (mGuess.getText().toString().trim().equals("")) {
                mResult.setText(getResources().getString(R.string.result_empty));
            } else {
                mResult.setText(getResources().getString(R.string.result_bad));
            }

            if (mPresenter.getGame().getHints().size() == 20) {
                mResult.setText(getResources().getString(R.string.result_fail) + " " + mPresenter.getGame().getCurrent_page().getName());
                setButtonForPlayAgain();
            } else {
                mPresenter.addHint();
            }
        }
    }

    /**
     * Check the button because the game is finished
     */
    private void setButtonForPlayAgain() {
        mValideGuess.setText(getResources().getString(R.string.btn_play_again));
        mValideGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(JeuActivity.this, JeuActivity.class);
                i.putExtra("category1", mPresenter.getGame().getCategories()[0]);
                i.putExtra("category2", mPresenter.getGame().getCategories()[1]);
                i.putExtra("category3", mPresenter.getGame().getCategories()[2]);
                startActivity(i);
            }
        });
    }

    /**
     *
     * Modify the redirection if the button back is pressed.
     * Go to the main activity instead of going to the previous activity
     * (Usefull if the player decided to play again with the same categories)
     *
     */
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void setHints(List<String> hints) {
        this.hints = hints;
    }

    public List<String> getHints() {
        return  hints;
    }

    public ArrayAdapter<String> getHintAdapter() {
        return hintAdapter;
    }
}
