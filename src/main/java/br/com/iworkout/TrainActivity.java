package br.com.iworkout;

import android.os.Bundle;

import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;

import roboguice.inject.ContentView;

@ContentView(R.layout.train)
public class TrainActivity extends RoboSherlockActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
