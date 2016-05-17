package br.com.iworkout.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.Arrays;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Metrics;
import br.com.iworkout.db.entity.User;


public class LoginActivity extends DBFragmentActivity  {

    final String PREFS_NAME = "MyPrefsFile";
    private SharedPreferences settings;
    private String  path;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RuntimeExceptionDao<User,Integer> dao = super.getHelper().getUserDao();
        List<User> users = dao.queryForAll();

        if (users != null && users.size() > 0){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        setContentView(R.layout.login_activity);
        path = this.getFilesDir().getAbsolutePath();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void logar(View view) {
        TextView nome = (TextView) findViewById(R.id.nome);

        RuntimeExceptionDao<User,Integer> dao = super.getHelper().getUserDao();
        User user = new User();
        user.setNome(nome.getText().toString());
        dao.create(user);

        RuntimeExceptionDao<Metrics, Integer> metricsDao = super.getHelper().getMetricsDao();
        List<Metrics> metrics = metricsDao.queryForAll();

        if (metrics !=null && metrics.size()>0 ){
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }

        Intent intent = new Intent(this, MetricsActivity.class);
        startActivity(intent);
        finish();
    }
}