package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import br.com.iworkout.R;

public class LoginActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
    }

    public void logar(View view){
        //TODO: regra de login
        //TODO: Verifica se já tem metricas definidas se não tiver manda pra tela de metricas:
        Intent intent = new Intent(this, MetricsActivity.class);
        startActivity(intent);

//        Intent intent = new Intent(this, MenuActivity.class);
//        startActivity(intent);

        finish();
    }

}

