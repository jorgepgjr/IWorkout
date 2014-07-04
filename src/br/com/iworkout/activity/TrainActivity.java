package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.MyDialogFragment;
import br.com.iworkout.util.adapter.TrainListAdapter;


public class TrainActivity extends DBActionBarActivity implements MyDialogFragment.NoticeDialogListener {

    ListView list;
    private List<Treino> treinos;

//    @InjectView(R.id.spinner)
//    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.train);
        list = (ListView) findViewById(R.id.list);
        loadTrainList();
        registerForContextMenu(list);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        loadTrainList();
    }

    private void loadTrainList() {
        treinos = getHelper().getTreinoDao().queryForAll();
        if (treinos != null && treinos.size() > 0) {
            TrainListAdapter adapter = new TrainListAdapter(this, treinos);
            list.setAdapter(adapter);
        }
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TrainActivity.this, TrainDetailsActivity.class);
                intent.putExtra("TREINO_ID", parent.getItemIdAtPosition(position));
                startActivity(intent);
            }
        });
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
                getHelper().getSerieDao().delete(treinos.get(info.position).getSeries());
                getHelper().getTreinoDao().delete(treinos.get(info.position));
                break;
        }
        loadTrainList();
        return super.onContextItemSelected(item);
    }

    public void onClickNewTrain(View view) {
        Intent intent = new Intent(this, ChooseMuscleActivity.class);
        startActivity(intent);
    }

    void showNoTrainsDialog() {
        MyDialogFragment dialog = new MyDialogFragment();
        dialog.show(getSupportFragmentManager(), "MyDialogFragment");
    }

    public void onClickSave(View view) {
//        RuntimeExceptionDao<Musculo, Integer> musculoDao = getHelper().getMusculoDao();
//        Musculo musculo = new Musculo();
//        musculo.setNome(txtMusculo.getText().toString());
//        musculoDao.create(musculo);
    }

    public void onClickShow(View view) {
//        RuntimeExceptionDao<Musculo, Integer> musculoDao = getHelper().getMusculoDao();
//        List<Musculo> list = musculoDao.queryForAll();
//
//
//        for (Musculo musculo : list) {
//            Toast toast = Toast.makeText(this, musculo.getNome() + list.size(), Toast.LENGTH_SHORT);
//            toast.show();
//        }
//        http://www.androidhive.info/2012/02/android-custom-listview-with-image-and-text/
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {

    }

}
