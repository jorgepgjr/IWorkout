package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import br.com.iworkout.R;
import roboguice.inject.ContentView;


@ContentView(R.layout.choose_serie)
public class ChooseSerieActivity extends DBFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

//    public void saveExercicioClick(View view){
//        Intent intent = new Intent(this, Choose.class);
//        startActivity(intent);
//    }

}
