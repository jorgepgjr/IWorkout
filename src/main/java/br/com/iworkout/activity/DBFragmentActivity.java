package br.com.iworkout.activity;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import br.com.iworkout.db.DatabaseHelper;
import roboguice.activity.RoboFragmentActivity;

/**
 * Created by Jorge on 10/07/13.
 */
public class DBFragmentActivity extends RoboFragmentActivity{

    private DatabaseHelper databaseHelper = null;

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
