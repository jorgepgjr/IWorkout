package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.util.SessionManager;


public class ChooseMuscleActivity extends DBActionBarActivity {

    EditText nomeTreino;
    Treino treino;
    boolean isNovoTreino;

//    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_musculo);
        nomeTreino = (EditText) findViewById(R.id.nomeTreino);
        treino = (Treino) getIntent().getSerializableExtra("treino");
        isNovoTreino = (treino == null);
//        Esse caso é quando estamos adicionando um musculo a um treino já existente
        if (!isNovoTreino) {
            nomeTreino.setVisibility(View.GONE);
        }else {
            treino = new Treino();
        }

//        sessionManager = new SessionManager(getApplicationContext());

    }

    public void musculoClick(View view) {

//        Se for um treino novo verificamos se o nome do texto foi preenchido
        if (isNovoTreino && nomeTreino.getText().toString().trim().equals("") ) {
            Toast toast = Toast.makeText(getApplicationContext(), "De um nome ao seu Treino", Toast.LENGTH_LONG);
            toast.show();
        } else {
            Integer musculoId = null;
            switch (view.getId()) {
                case R.id.abdominal:
                    musculoId = 1;
                    break;
                case R.id.biceps:
                    musculoId = 2;
                    break;
            }

            final Musculo musculo = super.getHelper().getMusculoDao().queryForId(musculoId);
            if (treino.getNome() == null) {
                treino.setNome(nomeTreino.getText().toString());
            }
            final Serie serie = new Serie();
            final Exercicio exercicio = new Exercicio();

            exercicio.setMusculo(musculo);
            serie.setExercicio(exercicio);

//        SharedPreferences.Editor editor = sessionManager.getEditor();
//        editor.putString(SessionManager.NOME_TREINO, nomeTreino.getText().toString());
//        editor.putInt(SessionManager.MUSCULO_ID, view.getId());
//        editor.commit();
            Intent intent = new Intent(this, ChooseExercicioActivity.class);
            intent.putExtra("newTreino", treino);
            intent.putExtra("newSerie", serie);
            intent.putExtra("musculoSelecioando", musculoId);
            startActivity(intent);
        }
    }
}
