package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import br.com.iworkout.R;

public class ApresentationActivity extends Activity {

    private ImageView fundo;
    private Integer[] telas;
    private int count = 0;
    final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences settings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time", true)) {
            setContentView(R.layout.apresentation_activity);
            fundo = (ImageView) findViewById(R.id.fundo);
            telas = new Integer[]{R.drawable.apresentacao_2_metas, R.drawable.apresentacao_3_evolucao, R.drawable.apresentacao_4_academia};
        }else{
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }
    }

    public void changeScreen(View view) {
        if (count < telas.length) {
            fundo.setBackgroundResource(telas[count++]);
        } else {
            settings.edit().putBoolean("my_first_time", false).commit();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

}

