package br.com.iworkout.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import br.com.iworkout.R;
import br.com.iworkout.db.DatabaseHelper;
import br.com.iworkout.util.ActionBarHelper;

/**
 * Created by Jorge on 10/07/13.
 */
public class DBActionBarActivity extends ActionBarActivity{

    private DatabaseHelper databaseHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().setCustomView(R.layout.action_bar);
        this.getSupportActionBar().setDisplayShowCustomEnabled(true);
        this.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (databaseHelper != null) {
            OpenHelperManager.releaseHelper();
            databaseHelper = null;
        }
    }

    protected DatabaseHelper getHelper() {
        if (databaseHelper == null) {
            databaseHelper =
                    OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
}
