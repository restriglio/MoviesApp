package base.apptrailers.mobile.globant.com.moviesapp.api;

import android.content.ContentValues;
import android.content.Context;

import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MoviesDataSource;
import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MyDatabaseHelper;
import base.apptrailers.mobile.globant.com.moviesapp.entity.Movie;

/**
 * Created by raul.striglio on 15/09/16.
 */
public class MyApi {

    private MoviesDataSource moviesDataSource;

    public MyApi(Context context){
        moviesDataSource = new MoviesDataSource(context);
    }

    public boolean saveData(){
        try {
            moviesDataSource.open();
            moviesDataSource.create(createMovie("batman", "Nolan", 2006, "Action"));
            moviesDataSource.create(createMovie("batman2", "Nolan", 2008, "Action"));
            moviesDataSource.create(createMovie("batman3", "Nolan", 2010, "Action"));

            moviesDataSource.close();

            return true;
        }catch(Exception e){
            return false;
        }
    }

    private ContentValues createMovie(String title, String director, int year, String gender){
        Movie batman = new Movie();
        batman.setName(title);
        batman.setDirector(gender);
        batman.setYear(year);
        batman.setGender(director);

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COLUMN_NAME,batman.getName());
        contentValues.put(MyDatabaseHelper.COLUMN_GENDER,batman.getGender());
        contentValues.put(MyDatabaseHelper.COLUMN_DIRECTOR,batman.getDirector());
        contentValues.put(MyDatabaseHelper.COLUMN_YEAR,batman.getYear());

        return contentValues;
    }



}
