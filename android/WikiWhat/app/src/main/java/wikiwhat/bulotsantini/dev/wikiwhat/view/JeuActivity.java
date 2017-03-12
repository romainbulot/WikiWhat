package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import wikiwhat.bulotsantini.dev.wikiwhat.R;

/**
 * Created by romain on 07/03/2017.
 */

public class JeuActivity  extends AppCompatActivity {


    private Button mValideGuess;


    ListView mListView;
    String[] prenoms = new String[]{
    "Indice n°1 : blabla", "Indice n°2 : blabla2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        mListView = (ListView) findViewById(R.id.listView);
        mValideGuess = (Button) findViewById(R.id.buttonValidInput);
        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(JeuActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }


    public void AfficherResult(View v)
    {
        TextView res = (TextView)findViewById(R.id.textResultat);
        res.setText("Erreur, un nouvel indice va apparaître");
    }


    public Button getmValideGuess() {
        return mValideGuess;
    }

}
