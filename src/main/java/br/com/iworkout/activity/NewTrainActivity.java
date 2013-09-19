package br.com.iworkout.activity;

import android.os.Bundle;
import android.widget.ListView;

import br.com.iworkout.R;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.new_train)
public class NewTrainActivity extends DBFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
