package br.com.iworkout.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;

import java.util.ArrayList;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.SessionManager;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.choose_musculo)
public class ChooseMuscleActivity extends DBFragmentActivity {

    @InjectView(R.id.nomeTreino)
    EditText nomeTreino;

    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
