package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;

import br.com.iworkout.R;
import br.com.iworkout.dialog.SerieDialog;
import br.com.iworkout.util.MyDialogFragment;
import roboguice.inject.ContentView;


@ContentView(R.layout.choose_exercicio)
public class ChooseExercicioActivity extends DBFragmentActivity implements SerieDialog.NoticeDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void saveExercicioClick(View view){
        SerieDialog dialog = new SerieDialog();
        dialog.show(getSupportFragmentManager(), "Serie Dialog");

//        Intent intent = new Intent(this, ChooseSerieActivity.class);
//        startActivity(intent);
    }

    @Override
    public void onDialogPositiveClick(RoboSherlockDialogFragment dialog) {

    }

    @Override
    public void onDialogNegativeClick(RoboSherlockDialogFragment dialog) {

    }
}
