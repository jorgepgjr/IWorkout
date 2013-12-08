package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;

import br.com.iworkout.R;
import br.com.iworkout.dialog.SerieDialog;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.choose_exercicio)
public class ChooseExercicioActivity extends DBFragmentActivity implements SerieDialog.NoticeDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void saveExercicioClick(View view){
        SerieDialog dialog = new SerieDialog();
        dialog.show(getSupportFragmentManager(), "Serie Dialog");
    }

    @Override
    public void onDialogPositiveClick(RoboSherlockDialogFragment dialog) {
        dialog.dismiss();
    }

    @Override
    public void onDialogNegativeClick(RoboSherlockDialogFragment dialog) {
        dialog.dismiss();
    }
}
