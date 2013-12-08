package br.com.iworkout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.rtyley.android.sherlock.roboguice.fragment.RoboSherlockDialogFragment;

import br.com.iworkout.R;
import br.com.iworkout.dialog.SerieDialog;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

public class ChooseSerieActivity extends DBFragmentActivity {
    @InjectView(R.id.repeatDecrease)
    ImageButton repeatDecrease;

    @InjectView(R.id.repiticoes)
    TextView repeticoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void onClickRepeatDecrease(View view){
        repeticoes.setText(Integer.valueOf(String.valueOf(repeticoes.getText())) + 1);
    }
//    public void saveExercicioClick(View view){
//        Intent intent = new Intent(this, Choose.class);
//        startActivity(intent);
//    }

}
