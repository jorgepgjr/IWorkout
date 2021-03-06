package br.com.iworkout.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

import br.com.iworkout.db.entity.Exercicio;
import br.com.iworkout.db.entity.Metrics;
import br.com.iworkout.db.entity.Musculo;
import br.com.iworkout.db.entity.Serie;
import br.com.iworkout.db.entity.Treino;
import br.com.iworkout.db.entity.User;

/**
 * Database helper class used to manage the creation and upgrading of your database. This class also usually provides
 * the DAOs used by the other classes.
 */
public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

    // name of the database file for your application -- change to something appropriate for your app
    private static final String DATABASE_NAME = "iworkout.db";
    // any time you make changes to your database objects, you may have to increase the database version
    private static final int DATABASE_VERSION = 33;

    // the DAO object we use to access the all tables
    private RuntimeExceptionDao<Musculo, Integer> musculoDao = null;
    private RuntimeExceptionDao<Exercicio, Integer> exercicioDao = null;
    private RuntimeExceptionDao<Treino, Integer> treinoDao = null;
    private RuntimeExceptionDao<Serie, Integer> serieDao = null;
    private RuntimeExceptionDao<Metrics, Integer> metricsDao = null;
    private RuntimeExceptionDao<User, Integer> userDao = null;

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
            TableUtils.createTable(connectionSource, Exercicio.class);
            TableUtils.createTable(connectionSource, Serie.class);
            TableUtils.createTable(connectionSource, Treino.class);
            TableUtils.createTable(connectionSource, Metrics.class);
            TableUtils.createTable(connectionSource, User.class);

            fillMusculo();
            fillExercicio();
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't create database", e);
            throw new RuntimeException(e);
        }
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
            TableUtils.dropTable(connectionSource, Exercicio.class, true);
            TableUtils.dropTable(connectionSource, Serie.class, true);
            TableUtils.dropTable(connectionSource, Treino.class, true);
            TableUtils.dropTable(connectionSource, Metrics.class, true);
            TableUtils.dropTable(connectionSource, User.class, true);
            // after we drop the old databases, we create the new ones
            onCreate(db, connectionSource);
        } catch (SQLException e) {
            Log.e(DatabaseHelper.class.getName(), "Can't drop databases", e);
            throw new RuntimeException(e);
        }
    }

    public void fillMusculo(){
        getMusculoDao().create(new Musculo("Abdominal"));
        getMusculoDao().create(new Musculo("Aerobico"));
        getMusculoDao().create(new Musculo("Biceps"));
        getMusculoDao().create(new Musculo("Costas"));
        getMusculoDao().create(new Musculo("Ombro"));
        getMusculoDao().create(new Musculo("Peitoral"));
        getMusculoDao().create(new Musculo("Pernas"));
        getMusculoDao().create(new Musculo("Triceps"));

    }

    public void fillExercicio(){
        //Abdominal
        getExercicioDao().create(new Exercicio("Simples", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Canivete", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Crunch", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Cruzado", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Flexão de Quadril", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Quatro tempos", getMusculoDao().queryForId(1)));
        getExercicioDao().create(new Exercicio("Flexão Pé a Pé", getMusculoDao().queryForId(1)));
        //Aerobico
        getExercicioDao().create(new Exercicio("Corrida", getMusculoDao().queryForId(2)));
        getExercicioDao().create(new Exercicio("Corda", getMusculoDao().queryForId(2)));

        //Biceps
        getExercicioDao().create(new Exercicio("Rosca Direta", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Rosca Alternada", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Rosca Invertida", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Rosca Concentrada", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Scott", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Martelo", getMusculoDao().queryForId(3)));
        getExercicioDao().create(new Exercicio("Vinte e um", getMusculoDao().queryForId(3)));
        //Costas
        getExercicioDao().create(new Exercicio("Remada Fechada", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Rosca Aberta", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Puxada Frontal", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Puxada Atrás", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Puxada Invertida", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Pull Down", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Remada Alta", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Remada Baixa", getMusculoDao().queryForId(4)));
        getExercicioDao().create(new Exercicio("Remada Unilateral", getMusculoDao().queryForId(4)));

        //Ombro
        getExercicioDao().create(new Exercicio("Elevação Frontal", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Elevação Lateral", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Elevação Diagonal", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Encolhimento Barra", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Encolhimento Haltere", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Desenvolvimento Nuca", getMusculoDao().queryForId(5)));
        getExercicioDao().create(new Exercicio("Desenvolvimento Máquina", getMusculoDao().queryForId(5)));

        //Peitoral
        getExercicioDao().create(new Exercicio("Supino Reto", getMusculoDao().queryForId(6)));
        getExercicioDao().create(new Exercicio("Supino Inclinado", getMusculoDao().queryForId(6)));
        getExercicioDao().create(new Exercicio("Supino Declinado", getMusculoDao().queryForId(6)));
        getExercicioDao().create(new Exercicio("Pull Over", getMusculoDao().queryForId(6)));
        getExercicioDao().create(new Exercicio("Peck Deck", getMusculoDao().queryForId(6)));
        getExercicioDao().create(new Exercicio("Flexão", getMusculoDao().queryForId(6)));


        //Pernas
        getExercicioDao().create(new Exercicio("Agachamento", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Stiff", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Extensora", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Extensora Unilateral", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Flexora", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Flexora Unilateral", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Adutor", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Abdutor", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Panturrilha", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Gêmeos", getMusculoDao().queryForId(7)));
        getExercicioDao().create(new Exercicio("Leg Press 45", getMusculoDao().queryForId(7)));

        //Triceps
        getExercicioDao().create(new Exercicio("Pulley", getMusculoDao().queryForId(8)));
        getExercicioDao().create(new Exercicio("Pulley Invertido", getMusculoDao().queryForId(8)));
        getExercicioDao().create(new Exercicio("Testa", getMusculoDao().queryForId(8)));
        getExercicioDao().create(new Exercicio("Corda", getMusculoDao().queryForId(8)));
        getExercicioDao().create(new Exercicio("Banco", getMusculoDao().queryForId(8)));
        getExercicioDao().create(new Exercicio("Francês", getMusculoDao().queryForId(8)));

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

    public RuntimeExceptionDao<Metrics, Integer> getMetricsDao() {
        if (metricsDao == null) {
            metricsDao = getRuntimeExceptionDao(Metrics.class);
        }
        return metricsDao;
    }


    public RuntimeExceptionDao<User, Integer> getUserDao() {
        if (userDao == null) {
            userDao = getRuntimeExceptionDao(User.class);
        }
        return userDao;
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
