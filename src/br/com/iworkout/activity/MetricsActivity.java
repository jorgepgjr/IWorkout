package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.LinkedList;

import br.com.iworkout.R;

public class MetricsActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";
    private Integer[] telas;
    private int count;
    SharedPreferences settings;
    View middle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: verificar se já tem as metricas traçadas
        setContentView(R.layout.metrics_activity);
        telas = new Integer[]{R.layout.metrics_activity, R.layout.metrics_midle_weight};

    }

    public void ok(View view){
        //TODO: Salva os dados
        proximaTela();
    }

    public void pular(View view){
        proximaTela();
    }

    public void voltar(View view){
        onBackPressed();
    }

    public void agoraNao(View view){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }


    private void proximaTela(){
        if (count < telas.length -1) {
            middle = findViewById(R.id.middle);
            ViewGroup parent = (ViewGroup) middle.getParent();
            int index = parent.indexOfChild(middle);
            parent.removeView(middle);
            middle = getLayoutInflater().inflate(telas[++count], parent,false);
            parent.addView(middle);
        } else {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * Quando clickar no botão de voltar, manda para a ela de treino.
     */
    @Override
    public void onBackPressed() {
        if (count > 0) {
            middle = findViewById(R.id.middle);
            ViewGroup parent = (ViewGroup) middle.getParent();
            int index = parent.indexOfChild(middle);
            parent.removeView(middle);
            middle = getLayoutInflater().inflate(telas[--count], parent,false);
            parent.addView(middle);
        } else {
            finish();
            super.onBackPressed();
        }
    }

}

