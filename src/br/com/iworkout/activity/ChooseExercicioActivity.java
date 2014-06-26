package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Date;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.dialog.SerieDialog;
import br.com.iworkout.util.SessionManager;


public class ChooseExercicioActivity extends DBFragmentActivity implements SerieDialog.NoticeDialogListener {

    SessionManager sessionManager;
    Treino newTreino;
    Serie newSerie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_exercicio);
        TextView nomeTreino = (TextView) findViewById(R.id.trainName);
        newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        newSerie = (Serie) getIntent().getSerializableExtra("newSerie");
        nomeTreino.setText(newTreino.getNome());
        sessionManager = new SessionManager(getApplicationContext());
    }

    public void saveExercicioClick(View view){
        DialogFragment dialog = new SerieDialog();
        dialog.show(getSupportFragmentManager(), "Serie Dialog");
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, TextView repeticoes, TextView serie, TextView peso){
        //Ver se náo vai dar pau
//        newTreino = (Treino) getIntent().getSerializableExtra("newTreino");

        newSerie.setRepiticoes(Long.valueOf(repeticoes.getText().toString()));
        newSerie.setCarga(Long.valueOf(peso.getText().toString()));
        newSerie.setQtd(Long.valueOf(serie.getText().toString()));

//        Integer musculoId = sessionManager.getPref().getInt(SessionManager.MUSCULO_ID,99);
//        Toast toast = Toast.makeText(getApplicationContext(), musculoId.toString(), Toast.LENGTH_LONG);
//        toast.show();
        dialog.dismiss();
        if (newTreino.getId() == null){
            newTreino.setDtInc(new Date());
        }else{
            newTreino.setDtAlt(new Date());
        }
        //TODO: Salvar exercicio

        getHelper().getTreinoDao().createOrUpdate(newTreino);
        newSerie.setTreino(newTreino);
        getHelper().getSerieDao().createOrUpdate(newSerie);
        Intent intent = new Intent(this, TrainDetailsActivity.class);
        intent.putExtra("TREINO_ID", newTreino.getId());
        startActivity(intent);
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        Toast toast = Toast.makeText(getApplicationContext(), "É necessaário prencher os dados da sua serie", Toast.LENGTH_LONG);
        toast.show();
        dialog.dismiss();
    }
}
