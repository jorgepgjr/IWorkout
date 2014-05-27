package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.dialog.SerieDialog;
import br.com.iworkout.util.SessionManager;


public class ChooseExercicioActivity extends DBFragmentActivity implements SerieDialog.NoticeDialogListener {

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_exercicio);
        sessionManager = new SessionManager(getApplicationContext());
    }

    public void saveExercicioClick(View view){
        DialogFragment dialog = new SerieDialog();
        dialog.show(getSupportFragmentManager(), "Serie Dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, TextView repeticoes, TextView serie, TextView peso){
        final Treino newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        final Serie newSerie = newTreino.getSeries().get(newTreino.getSeries().size() -1);
        newSerie.setRepiticoes(Long.valueOf(repeticoes.getText().toString()));
        newSerie.setCarga(Long.valueOf(peso.getText().toString()));
        newSerie.setQtd(Long.valueOf(serie.getText().toString()));

//        Integer musculoId = sessionManager.getPref().getInt(SessionManager.MUSCULO_ID,99);
//        Toast toast = Toast.makeText(getApplicationContext(), musculoId.toString(), Toast.LENGTH_LONG);
//        toast.show();
        dialog.dismiss();

        Intent intent = new Intent(this, NewTrainActivity.class);
        intent.putExtra("newTreino", newTreino);
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast toast = Toast.makeText(getApplicationContext(), "É necessaário prencher os dados da sua serie", Toast.LENGTH_LONG);
        toast.show();
        dialog.dismiss();
    }
}
