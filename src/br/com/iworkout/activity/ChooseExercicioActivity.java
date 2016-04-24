package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.dialog.SerieDialog;
import br.com.iworkout.util.adapter.ExerciseListAdapter;
import br.com.iworkout.util.helper.MusculoHelper;


public class ChooseExercicioActivity extends DBActionBarActivity implements SerieDialog.NoticeDialogListener {

    private Treino newTreino;
    private Serie newSerie;
    private ListView list;
    private ImageButton musculoSelecionadoImgBt;
    private List<Exercicio> exercicios;
    private Exercicio exercicioSelecionado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_exercicio);

        //Map dos objetos de tela
        TextView nomeTreino = (TextView) findViewById(R.id.trainName);
        musculoSelecionadoImgBt = (ImageButton) findViewById(R.id.musculoSelecionado);
        list = (ListView) findViewById(R.id.listView);

        //Map dos obejetos passados pelas outras activities
        newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        newSerie = (Serie) getIntent().getSerializableExtra("newSerie");
        int idMusculoSelecionado = getIntent().getExtras().getInt("musculoSelecioando");

        exercicios = super.getHelper().getExercicioDao().queryForEq("musculo_id",idMusculoSelecionado);
        nomeTreino.setText(newTreino.getNome());
        ExerciseListAdapter adapter = new ExerciseListAdapter(this, exercicios);
        list.setAdapter(adapter);

        musculoSelecionadoImgBt.setBackgroundResource(MusculoHelper.getMusculoIconById(idMusculoSelecionado));

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView arg0, View view, int position, long itemId) {
                exercicioSelecionado = exercicios.get(position);
                DialogFragment dialog = new SerieDialog();
                Bundle bundle = new Bundle();
                bundle.putString("musculo",exercicioSelecionado.getMusculo().getNome());
                bundle.putString("exercicio",exercicioSelecionado.getNome());
                dialog.setArguments(bundle);
                dialog.show(getSupportFragmentManager(), "Serie Dialog");
            }

        });
    }

//    public void saveExercicioClick(View view) {
//        DialogFragment dialog = new SerieDialog();
//        dialog.show(getSupportFragmentManager(), "Serie Dialog");
//    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, TextView repeticoes, TextView serie, TextView peso) {
        newSerie.setRepiticoes(Long.valueOf(repeticoes.getText().toString()));
        newSerie.setCarga(Long.valueOf(peso.getText().toString()));
        newSerie.setQtd(Long.valueOf(serie.getText().toString()));

        dialog.dismiss();

        if (newTreino.getId() == null) {
            newTreino.setDtInc(new Date());
            getHelper().getTreinoDao().create(newTreino);
        } else {
            newTreino = getHelper().getTreinoDao().queryForId(newTreino.getId().intValue());
            newTreino.setDtAlt(new Date());
            getHelper().getTreinoDao().update(newTreino);
        }

        newSerie.setTreino(newTreino);
        newSerie.setExercicio(exercicioSelecionado);
        getHelper().getSerieDao().createOrUpdate(newSerie);
        Intent intent = new Intent();
//                this, CreateTrainDetailsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
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
