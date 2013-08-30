package br.com.iworkout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        showNoTrainsDialog();
    }

    void showNoTrainsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.fragment_dialog, null));
        AlertDialog dialog = builder.create();
        dialog.show();
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


//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        final MyDialogFragment dialogFragment = new MyDialogFragment(R.layout.fragment_dialog);
//        dialogFragment.show(ft, "dialog");
//    http://developer.android.com/guide/topics/ui/dialogs.html

}
