package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.j256.ormlite.dao.ForeignCollection;

import br.com.iworkout.R;
import br.com.iworkout.db.DatabaseHelper;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.dialog.SerieDialog;
import br.com.iworkout.util.ActionBarHelper;
import br.com.iworkout.util.adapter.TrainDetailsListAdapter;

public class TrainDetailsActivity extends DBActionBarActivity {

    private ListView list;
    Long idTreinoSelecionado;
    Treino treino;
    ForeignCollection<Serie> series;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train_details);

        TextView nomeTreino = (TextView) findViewById(R.id.nomeTreinoTrainDetails);
        list = (ListView) findViewById(R.id.list);

        registerForContextMenu(list);
        idTreinoSelecionado = getIntent().getExtras().getLong("TREINO_ID");
        treino = super.getHelper().getTreinoDao().queryForId(idTreinoSelecionado.intValue());
        nomeTreino.setText(treino.getNome());
        series = treino.getSeries();
        loadList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 1, Menu.NONE, "Deletar");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
//            deletar
            case 1:
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                final Serie serie = (Serie) series.toArray()[info.position];
                getHelper().getSerieDao().delete(serie);
                break;
        }
        loadList();
        return super.onContextItemSelected(item);
    }

    private void loadList() {
        if (series != null && series.size() > 0){
            TrainDetailsListAdapter adapter = new TrainDetailsListAdapter(this,series);
            list.setAdapter(adapter);
        }
    }

    public void addExercicioClick(View view) {
        Intent intent = new Intent(this, ChooseMuscleActivity.class);
        intent.putExtra("treino", treino);
        startActivity(intent);
    }

    /**
     * Quando clickar no botão de voltar, manda para a ela de treino.
     */
    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(this, TrainActivity.class);
        startActivity(backIntent);
        finish();
        super.onBackPressed();
    }
}
