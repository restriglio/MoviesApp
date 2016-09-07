package base.apptrailers.mobile.globant.com.moviesapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import base.apptrailers.mobile.globant.com.moviesapp.MoviesContract;

/**
 * Created by raul.striglio on 02/09/16.
 */
public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "movies.db";
    public static final String MOVIES_TABLE_NAME = "Movies";
    public static final int DATABASE_VERSION = 1;

    private static MyDatabaseHelper instance;

    static final String DB_TABLE =
            " CREATE TABLE " + MOVIES_TABLE_NAME +
                    " (" + MoviesContract.Movies.Cols.COLUMN_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    MoviesContract.Movies.Cols.COLUMN_NAME +  " TEXT NOT NULL, " +
                    MoviesContract.Movies.Cols.COLUMN_YEAR + " INTEGER NOT NULL, " +
                    MoviesContract.Movies.Cols.COLUMN_DIRECTOR + " TEXT NOT NULL, " +
                    MoviesContract.Movies.Cols.COLUMN_GENDER + " TEXT NOT NULL);";

    private MyDatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static MyDatabaseHelper getInstance(Context context){
        if(instance == null){
            instance = new MyDatabaseHelper(context);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  MOVIES_TABLE_NAME);
        onCreate(db);
    }
}