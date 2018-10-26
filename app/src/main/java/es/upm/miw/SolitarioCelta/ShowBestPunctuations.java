package es.upm.miw.SolitarioCelta;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowBestPunctuations extends AppCompatActivity {

    ListView lvPunctuation;
    private GamePunctuationRepository db;
    ArrayList<GamePunctuation> punctuations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_best_punctuations);
        lvPunctuation = findViewById(R.id.lvListadoPuntuaciones);
        db = new GamePunctuationRepository(this);
        punctuations = db.getAll();

        lvPunctuation.setAdapter(new GamePunctuationAdapter(
                this,
                punctuations,
                R.layout.layout_punctuations_list
        ));
    }


    public void deleteBD (View view){
        new DeleteInformationDialogFragment().show(getFragmentManager(),"DIALOG");
    }
}
