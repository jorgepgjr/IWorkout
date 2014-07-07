package br.com.iworkout.util;

import android.support.v7.app.ActionBarActivity;

import br.com.iworkout.R;

public class ActionBarHelper {

    public static void createActionBar(ActionBarActivity activity) {
        activity.getSupportActionBar().setCustomView(R.layout.action_bar);
        activity.getSupportActionBar().setDisplayShowCustomEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
}