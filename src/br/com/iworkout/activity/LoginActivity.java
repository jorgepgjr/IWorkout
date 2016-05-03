package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.Arrays;

import br.com.iworkout.R;


public class LoginActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";
    private SharedPreferences settings;
    private String  path;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        path = this.getFilesDir().getAbsolutePath();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void logar(View view) {
        //TODO: regra de login
        //TODO: Verifica se já tem metricas definidas se não tiver manda pra tela de metricas:
        Intent intent = new Intent(this, MetricsActivity.class);
        startActivity(intent);
//        Intent intent = new Intent(this, MenuActivity.class);
//        startActivity(intent);
        finish();
    }


    //Obrigatório sobrescrever para usar o Helper de life cycle do FACEBOOK
    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
//        Session session = Session.getActiveSession();
//        if (session != null &&
//                (session.isOpened() || session.isClosed()) ) {
//            onSessionStateChange(session, session.getState(), null);
//        }

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}