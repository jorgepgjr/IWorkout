package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.SessionManager;


public class ChooseMuscleActivity extends br.com.iworkout.activity.DBActivity {

    EditText nomeTreino;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_musculo);
        nomeTreino = (EditText) findViewById(R.id.nomeTreino);
        sessionManager = new SessionManager(getApplicationContext());

    }

    public void musculoClick(View view){
        final Treino newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        final List<Serie> series;
        final Serie serie = new Serie();
        final Exercicio exercicio = new Exercicio();
        final List musculos = new ArrayList<Musculo>();
        final Musculo musculo = new Musculo("Abdominal");

        if (CollectionUtils.isEmpty(newTreino.getSeries())){
            series = new ArrayList<Serie>();
        }else{
            series = newTreino.getSeries();
        }

        newTreino.setNome(nomeTreino.getText().toString());
        musculos.add(musculo); //TODO: pegar do banco o nome do exercicio, ou ver outra alternativa
        exercicio.setMusculos(musculos);
        serie.setExercicio(exercicio);
        series.add(serie);
        newTreino.setSeries(series);

//        SharedPreferences.Editor editor = sessionManager.getEditor();
//        editor.putString(SessionManager.NOME_TREINO, nomeTreino.getText().toString());
//        editor.putInt(SessionManager.MUSCULO_ID, view.getId());
//        editor.commit();
        Intent intent = new Intent(this, ChooseExercicioActivity.class);
        intent.putExtra("newTreino", newTreino);
        startActivity(intent);
    }
}
