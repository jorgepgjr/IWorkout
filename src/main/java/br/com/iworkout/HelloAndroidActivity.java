package br.com.iworkout;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.view.Menu;
import com.github.rtyley.android.sherlock.roboguice.activity.RoboSherlockActivity;

import roboguice.inject.ContentView;
import roboguice.inject.InjectView;

@ContentView(R.layout.activity_main)
public class HelloAndroidActivity extends RoboSherlockActivity implements ActionBar.OnNavigationListener {
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

        train.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                CharSequence text = "Hello toast!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), text, duration);
                toast.show();
            }
        });
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

