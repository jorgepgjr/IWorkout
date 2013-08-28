package br.com.iworkout.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "iworkout.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 10;

    // the DAO object we use to access the Musculo table
    private RuntimeExceptionDao<Musculo, Integer> musculoDao = null;
    private RuntimeExceptionDao<Exercicio, Integer> exercicioDao = null;
    private RuntimeExceptionDao<Treino, Integer> treinoDao = null;
    private RuntimeExceptionDao<Serie, Integer> serieDao = null;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is first created. Usually you should call createTable statements here to create
     * the tables that will store your data.
     */
    @Override
    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onCreate");
            TableUtils.createTable(connectionSource, Musculo.class);
            TableUtils.createTable(connectionSource, Serie.class);
            TableUtils.createTable(connectionSource, Exercicio.class);
            TableUtils.createTable(connectionSource, Treino.class);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }

        // here we try inserting data in the on-create as a test
        RuntimeExceptionDao<Musculo, Integer> dao = getMusculoDao();

        List musculos = new ArrayList();
        // create some entries in the onCreate
        Musculo simple = new Musculo("Perna");
        dao.create(simple);

        Musculo simple2 = new Musculo("Braço");
        dao.create(simple2);

        musculos.add(simple);
        musculos.add(simple2);
        Exercicio exercicio = new Exercicio();
        exercicio.setMusculos(musculos);


        getExercicioDao().create(exercicio);

        Log.i(DatabaseHelper.class.getName(), "created new entries in onCreate");
    }

    /**
     * This is called when your application is upgraded and it has a higher version number. This allows you to adjust
     * the various data to match the new version number.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            Log.i(DatabaseHelper.class.getName(), "onUpgrade");
            TableUtils.dropTable(connectionSource, Musculo.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Returns the RuntimeExceptionDao (Database Access Object) version of a Dao for our SimpleData class. It will
     * create it or just give the cached value. RuntimeExceptionDao only through RuntimeExceptions.
     */
    public RuntimeExceptionDao<Musculo, Integer> getMusculoDao() {
        if (musculoDao == null) {
            musculoDao = getRuntimeExceptionDao(Musculo.class);
        }
        return musculoDao;
    }

    public RuntimeExceptionDao<Exercicio, Integer> getExercicioDao() {
        if (exercicioDao == null) {
            exercicioDao = getRuntimeExceptionDao(Exercicio.class);
        }
        return exercicioDao;
    }

    public RuntimeExceptionDao<Serie, Integer> getSerieDao() {
        if (serieDao == null) {
            serieDao = getRuntimeExceptionDao(Serie.class);
        }
        return serieDao;
    }

    public RuntimeExceptionDao<Treino, Integer> getTreinoDao() {
        if (treinoDao == null) {
            treinoDao = getRuntimeExceptionDao(Treino.class);
        }
        return treinoDao;
    }

    /**
     * Close the database connections and clear any cached DAOs.
     */
    @Override
    public void close() {
        super.close();
        musculoDao = null;
    }
}
