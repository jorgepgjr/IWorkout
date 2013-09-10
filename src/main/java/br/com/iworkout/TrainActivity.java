package br.com.iworkout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;


import java.util.Arrays;
import java.util.List;

import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.MyDialogFragment;
import br.com.iworkout.util.adapter.TrainListAdapter;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.train)
public class TrainActivity extends DBFragmentActivity implements MyDialogFragment.NoticeDialogListener{

    @InjectView(R.id.list)
    ListView list;

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
