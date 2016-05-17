package br.com.iworkout.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.Date;

import br.com.iworkout.R;
import br.com.iworkout.components.CustomEditText;
import br.com.iworkout.db.entity.Metrics;

public class NewMetricsActivity extends DBFragmentActivity {

    final String PREFS_NAME = "MyPrefsFile";
    private Integer[] telas;
    private int count = 0;
    SharedPreferences settings;
    View middle;
    private Metrics metrics = new Metrics();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_metrics);
    }

    public void ok(View view) {
        CustomEditText braco = (CustomEditText) findViewById(R.id.braco);
        metrics.setBraco(braco.getValue());

        CustomEditText a = (CustomEditText) findViewById(R.id.new_peso);
        metrics.setPeso(a.getValue());

        CustomEditText peitoral = (CustomEditText) findViewById(R.id.peitoral);
        metrics.setPeitoral(peitoral.getValue());

        CustomEditText cintura = (CustomEditText) findViewById(R.id.cintura);
        metrics.setCintura(cintura.getValue());

        CustomEditText coxa = (CustomEditText) findViewById(R.id.coxa);
        metrics.setCoxa(coxa.getValue());

        metrics.setDtInc(new Date());

        RuntimeExceptionDao<Metrics, Integer> dao = super.getHelper().getMetricsDao();
        dao.create(metrics);
        super.onBackPressed();
    }

    public void voltar(View view) {
        onBackPressed();
    }

}

