package br.com.iworkout;

import android.os.Bundle;
import android.widget.Button;

import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;

import roboguice.inject.InjectView;

public class HelloAndroidActivity extends RoboSherlockActivity {
    @InjectView(R.id.button) Button button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button.setText("Teste do roboguice com sherlock");
    }

}

