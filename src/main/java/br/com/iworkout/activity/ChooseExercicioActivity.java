package br.com.iworkout.activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

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
        DialogFragment dialog = new SerieDialog();
        dialog.show(getSupportFragmentManager(), "Serie Dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        Toast toast = Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_LONG);
        toast.show();
        dialog.dismiss();
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast toast = Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_LONG);
        toast.show();
        dialog.dismiss();
    }
}
