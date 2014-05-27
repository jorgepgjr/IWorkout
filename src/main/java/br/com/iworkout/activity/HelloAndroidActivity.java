package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.j256.ormlite.dao.RuntimeExceptionDao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.iworkout.R;
import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;

public class HelloAndroidActivity extends  DBFragmentActivity{
    ImageButton gym;
    ImageButton friends;
    ImageButton results;
    ImageButton train;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         gym = (ImageButton) findViewById(R.id.imgBtnMyGym);
         friends = (ImageButton) findViewById(R.id.imgBtnFriends);
         results = (ImageButton) findViewById(R.id.imgBtnResults);
         train = (ImageButton) findViewById(R.id.imgBtnTrain);


//        list.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);
//        getSupportActionBar().setCustomView(R.layout.action_bar);
//        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
//        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
//        getSupportActionBar().setListNavigationCallbacks(list, this);
    }

    public void onClickTrain(View view){
        Intent intent = new Intent(this, TrainActivity.class);
        startActivity(intent);
    }

    public void onClickSegundo(View view){
        RuntimeExceptionDao<Exercicio, Integer> exercicioDao = getHelper().getExercicioDao();
        RuntimeExceptionDao<Musculo,Integer> musculoDao = getHelper().getMusculoDao();
        RuntimeExceptionDao<Serie, Integer> serieDao = getHelper().getSerieDao();
        RuntimeExceptionDao<Treino, Integer> treinoDao = getHelper().getTreinoDao();

        List musculos = new ArrayList<Musculo>();
        Musculo musculo = new Musculo();
        musculo.setNome("Bicipes");
        int id = musculoDao.create(musculo);

        musculo = musculoDao.queryForId(id);
        musculos.add(musculo);

        Exercicio exercicio = new Exercicio();
        exercicio.setNome("Rosca Direta");
        exercicio.setMusculos(musculos);

        Serie serie = new Serie();
        serie.setExercicio(exercicio);
        id = serieDao.create(serie);
        serie = serieDao.queryForId(id);
        List series = new ArrayList<Serie>();
        series.add(serie);

        Treino treino = new Treino();
        treino.setNome("Treino 1");
        treino.setSeries(series);
        treino.setDtInc(new Date());
        treinoDao.create(treino);

    }

}

