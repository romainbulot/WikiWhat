package wikiwhat.bulotsantini.dev.wikiwhat.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import wikiwhat.bulotsantini.dev.wikiwhat.R;

/**
 * Created by romain on 07/03/2017.
 */

public class JeuActivity  extends AppCompatActivity {

    ListView mListView;
    String[] prenoms = new String[]{
    "Indice n°1 : blabla", "Indice n°2 : blabla2"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        mListView = (ListView) findViewById(R.id.listView);

        //android.R.layout.simple_list_item_1 est une vue disponible de base dans le SDK android,
        //Contenant une TextView avec comme identifiant "@android:id/text1"

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(JeuActivity.this,
                android.R.layout.simple_list_item_1, prenoms);
        mListView.setAdapter(adapter);
    }
}
