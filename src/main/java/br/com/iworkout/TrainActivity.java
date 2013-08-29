package br.com.iworkout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.List;

import br.com.iworkout.db.entity.Musculo;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.train)
public class TrainActivity extends DBActivity {

    @InjectView(R.id.editText)
    EditText txtMusculo;

    @InjectView(R.id.button)
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //showDialog();

    }

    public void onClickSave(View view) {
        RuntimeExceptionDao<Musculo, Integer> musculoDao = getHelper().getMusculoDao();
        Musculo musculo = new Musculo();
        musculo.setNome(txtMusculo.getText().toString());
        musculoDao.create(musculo);
    }

    public void onClickShow(View view) {
        RuntimeExceptionDao<Musculo, Integer> musculoDao = getHelper().getMusculoDao();
        List<Musculo> list = musculoDao.queryForAll();


        for (Musculo musculo : list) {
            Toast toast = Toast.makeText(this, musculo.getNome() + list.size(), Toast.LENGTH_SHORT);
            toast.show();
        }
    }




}
