package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import br.com.iworkout.R;
import br.com.iworkout.components.CustomEditText;
import br.com.iworkout.db.entity.Metrics;

public class MetricsActivity extends Activity {

    final String PREFS_NAME = "MyPrefsFile";
    private Integer[] telas;
    private int count= 0;
    SharedPreferences settings;
    View middle;
    private Metrics metrics = new Metrics();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO: verificar se já tem as metricas traçadas, se já tiver não mostrar o fluxo de criação de metas
        setContentView(R.layout.metrics_activity);
        telas = new Integer[]{R.layout.metrics_activity, R.layout.metrics_midle_sex, R.layout.metrics_midle_weight, R.layout.metrics_midle_up_body
                , R.layout.metrics_midle_lower_body, R.layout.metrics_midle_finish};

    }

    public void ok(View view) {
        //TODO: Salva os dados

        switch (telas[count]){
            case R.layout.metrics_midle_sex:
                //TODO:ver como faz pra pegar o radiobutton
                break;
            case R.layout.metrics_midle_weight:
                CustomEditText a = (CustomEditText) findViewById(R.id.peso);
                metrics.setPeso(a.getValue());
                break;
            case R.layout.metrics_midle_up_body:
                CustomEditText braco = (CustomEditText) findViewById(R.id.braco);
                metrics.setBraco(braco.getValue());

                CustomEditText antebraco = (CustomEditText) findViewById(R.id.antebraco);
                metrics.setAntebraco(antebraco.getValue());

                CustomEditText peitoral = (CustomEditText) findViewById(R.id.peitoral);
                metrics.setPeitoral(peitoral.getValue());

                break;
            case R.layout.metrics_midle_lower_body:
                break;


        }

        proximaTela();
    }

    public void pular(View view) {
        proximaTela();
    }

    public void voltar(View view) {
        onBackPressed();
    }

    public void agoraNao(View view) {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
        finish();
    }


    private void proximaTela() {
        if (count < telas.length - 1) {
            middle = findViewById(R.id.middle);
            ViewGroup parent = (ViewGroup) middle.getParent();
            int index = parent.indexOfChild(middle);
            parent.removeView(middle);
            middle = getLayoutInflater().inflate(telas[++count], parent, false);
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
            middle = getLayoutInflater().inflate(telas[--count], parent, false);
            parent.addView(middle);
        } else {
            finish();
            super.onBackPressed();
        }
    }

}

