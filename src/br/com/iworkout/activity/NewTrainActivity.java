package br.com.iworkout.activity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.adapter.SerieListAdapter;


public class NewTrainActivity extends DBFragmentActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_train);
        list = (ListView) findViewById(R.id.list);
        final Treino newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        Toast toast = Toast.makeText(getApplicationContext(), newTreino.getNome(), Toast.LENGTH_LONG);
        toast.show();
        final SerieListAdapter adapter = new SerieListAdapter(this,newTreino.getSeries());
        list.setAdapter(adapter);
//        List<Treino> treinos = getHelper().getTreinoDao().queryForAll();
//        if (treinos != null && treinos.size() > 0){
//        }
//        showNoTrainsDialog();
    }

}
