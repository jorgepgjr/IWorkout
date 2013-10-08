package br.com.iworkout.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Jorge on 10/2/13.
 */
public class SessionManager {

    /**
     * Criando configuração de Sessão
     */
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    private SharedPreferences.Editor editor;

    Context context;
    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "MonitoreFitness";

    // All Shared Preferences Keys
    public static final String MUSCULO_ID = "musculoID";

    public static final String NOME_TREINO = "nomeTreino";
    // Constructor
    public SessionManager(Context context){
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    public void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

}


