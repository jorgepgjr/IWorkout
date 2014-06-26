package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.j256.ormlite.dao.ForeignCollection;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;

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
        Integer musculoId = null;

        switch (view.getId()){
            case R.id.abdominal:
                musculoId = 1;
                break;
            case R.id.biceps:
                musculoId = 2;
                break;
        }

        final Musculo musculo = super.getHelper().getMusculoDao().queryForId(musculoId);
        final Treino newTreino = (Treino) getIntent().getSerializableExtra("newTreino");
        newTreino.setNome(nomeTreino.getText().toString());

        final Serie serie = new Serie();
        final Exercicio exercicio = new Exercicio();

        exercicio.setMusculo(musculo);
        serie.setExercicio(exercicio);

//        SharedPreferences.Editor editor = sessionManager.getEditor();
//        editor.putString(SessionManager.NOME_TREINO, nomeTreino.getText().toString());
//        editor.putInt(SessionManager.MUSCULO_ID, view.getId());
//        editor.commit();
        Intent intent = new Intent(this, ChooseExercicioActivity.class);
        intent.putExtra("newTreino", newTreino);
        intent.putExtra("newSerie", serie);
        startActivity(intent);
    }
}
