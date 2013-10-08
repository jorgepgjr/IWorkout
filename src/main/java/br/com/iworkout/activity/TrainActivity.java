package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;


import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.MyDialogFragment;
import br.com.iworkout.util.adapter.TrainListAdapter;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.train)
public class TrainActivity extends DBFragmentActivity implements MyDialogFragment.NoticeDialogListener{

    @InjectView(R.id.list)
    ListView list;

//    @InjectView(R.id.spinner)
//    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Treino> treinos = getHelper().getTreinoDao().queryForAll();
        if (treinos != null && treinos.size() > 0){
            TrainListAdapter adapter = new TrainListAdapter(this,treinos);
            list.setAdapter(adapter);
        }
//        showNoTrainsDialog();
    }


    public void onClickNewTrain(View view){
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
    public void onDialogPositiveClick(RoboSherlockDialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(RoboSherlockDialogFragment dialog) {

    }

}
