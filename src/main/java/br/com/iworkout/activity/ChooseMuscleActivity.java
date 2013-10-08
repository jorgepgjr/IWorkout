package br.com.iworkout.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.com.iworkout.R;
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

    public void muculoClick(View view){
        SharedPreferences.Editor editor = sessionManager.getEditor();
        editor.putString(SessionManager.NOME_TREINO, nomeTreino.getText().toString());
        editor.putInt(SessionManager.MUSCULO_ID, view.getId());
        Intent intent = new Intent(this, ChooseExercicioActivity.class);
        startActivity(intent);
    }
}
