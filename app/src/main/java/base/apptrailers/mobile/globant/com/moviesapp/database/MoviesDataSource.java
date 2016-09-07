package base.apptrailers.mobile.globant.com.moviesapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import base.apptrailers.mobile.globant.com.moviesapp.MoviesContract;
import base.apptrailers.mobile.globant.com.moviesapp.model.Movie;


/**
 * Created by raul.striglio on 02/09/16.
 */
public class MoviesDataSource implements IAccessData {

    private SQLiteDatabase database;
    private MyDatabaseHelper dbHelper;
    private static MoviesDataSource instance;
    public static String[] allColumns = { MoviesContract.Movies.Cols.COLUMN_ID,
            MoviesContract.Movies.Cols.COLUMN_NAME,
            MoviesContract.Movies.Cols.COLUMN_GENDER,
            MoviesContract.Movies.Cols.COLUMN_DIRECTOR,
            MoviesContract.Movies.Cols.COLUMN_YEAR};

    private MoviesDataSource(Context context){
        dbHelper = MyDatabaseHelper.getInstance(context);
    }

    public static MoviesDataSource getinstance(Context context) {
        if(instance == null){
            instance = new MoviesDataSource(context);
        }
        return instance;
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public SQLiteDatabase getDatabase(){
        return database;
    }

    public void close() {
        dbHelper.close();
    }

    public long create(ContentValues values){
        return database.insert(MyDatabaseHelper.MOVIES_TABLE_NAME, null, values);
    }

    public int delete(String table,String where, String[] whereValue){
        return database.delete(table,where,whereValue);
    }

    @Override
    public Cursor query(String[] projection, String where, String[] whereValue){
        return database.query(MyDatabaseHelper.MOVIES_TABLE_NAME, projection, where,
                whereValue,
                null, null, null);
    }

    public int update(String table, ContentValues values, String whereClause, String[] whereArgs){
        return database.update(table,values,whereClause,whereArgs);
    }

    public void deleteMovie (Movie movie) {
        long id = movie.getId();
        System.out.println("Movie deleted with id: " + id);
        database.delete(MyDatabaseHelper.MOVIES_TABLE_NAME,
                MoviesContract.Movies.Cols.COLUMN_ID
                + " = " + id,
                null);
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();

        Cursor cursor = database.query(MyDatabaseHelper.MOVIES_TABLE_NAME,
                allColumns, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Movie movie = cursorToMovie(cursor);
            movies.add(movie);
            cursor.moveToNext();
        }

        cursor.close();
        return movies;
    }

    private Movie cursorToMovie(Cursor cursor) {
        Movie movie = new Movie();
        movie.setId(cursor.getLong(0));
        movie.setName(cursor.getString(1));
        movie.setYear(cursor.getInt(1));
        movie.setDirector(cursor.getString(1));
        movie.setGender(cursor.getString(1));
        return movie;
    }

}
