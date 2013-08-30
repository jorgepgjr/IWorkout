package br.com.iworkout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockFragmentActivity;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class HelloAndroidActivity extends RoboSherlockFragmentActivity implements ActionBar.OnNavigationListener {
    @InjectView(R.id.imgBtnMyGym)
    ImageButton gym;
    @InjectView(R.id.imgBtnFriends)
    ImageButton friends;
    @InjectView(R.id.imgBtnResults)
    ImageButton results;
    @InjectView(R.id.imgBtnTrain)
    ImageButton train;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<CharSequence> list = ArrayAdapter.createFromResource(getApplicationContext(), R.array.locations, R.layout.sherlock_spinner_dropdown_item);
        list.setDropDownViewResource(R.layout.sherlock_spinner_dropdown_item);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
        getSupportActionBar().setListNavigationCallbacks(list, this);
    }

    public void onClickTrain(View view){
        Intent intent = new Intent(this, TrainActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        return false;
    }
}

