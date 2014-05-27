package br.com.iworkout.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import br.com.iworkout.R;

public class ChooseSerieActivity extends DBFragmentActivity {

    ImageButton repeatDecrease;
    TextView repeticoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        repeatDecrease = (ImageButton) findViewById(R.id.repeatDecrease);
        repeticoes = (TextView) findViewById(R.id.repiticoes);
    }

    public void onClickRepeatDecrease(View view){
        repeticoes.setText(Integer.valueOf(String.valueOf(repeticoes.getText())) + 1);
    }
//    public void saveExercicioClick(View view){
//        Intent intent = new Intent(this, Choose.class);
//        startActivity(intent);
//    }

}
