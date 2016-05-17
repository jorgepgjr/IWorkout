package br.com.iworkout.activity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.User;
import br.com.iworkout.util.ActionBarHelper;

public class MenuActivity extends DBActionBarActivity{
    ImageButton gym;
    ImageButton friends;
    ImageButton results;
    ImageButton train;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBarHelper.createActionBar(this);
        setContentView(R.layout.activity_main);
        User user = getHelper().getUserDao().queryForAll().get(0);
        TextView nomeAtleta = (TextView) findViewById(R.id.nomeAtleta);
        nomeAtleta.setText("Olá "+ user.getNome() +"! Vamos treinar?" );
//         gym = (ImageButton) findViewById(R.id.imgBtnMyGym);
         friends = (ImageButton) findViewById(R.id.imgBtnFriends);
         results = (ImageButton) findViewById(R.id.imgBtnResults);
         train = (ImageButton) findViewById(R.id.imgBtnTrain);
    }

    public void onClickTrain(View view){
        Intent intent = new Intent(this, TrainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onEvolucaoClick(View view) {
        Intent intent = new Intent(this, EvolucaoActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }


    public void onMinhaAcademiaClick(View view) {
        Intent intent = new Intent(this, SobreActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    public void onClickSegundo(View view){
        Intent intent = new Intent(this, NewMetricsActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

    }

    /**
     * Quando clickar no botão de voltar, manda para a ela de treino.
     */
    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

}

