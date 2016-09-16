package base.apptrailers.mobile.globant.com.moviesapp.api;

import android.content.ContentValues;
import android.content.Context;

import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MoviesDataSource;
import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MyDatabaseHelper;
import base.apptrailers.mobile.globant.com.moviesapp.entity.Movie;

/**
 * Created by raul.striglio on 15/09/16.
 */
public class MyApi implements IApi {

    private MoviesDataSource moviesDataSource;

    public MyApi(Context context){
        moviesDataSource = new MoviesDataSource(context);
    }

    @Override
    public void saveData(){
        try {

            moviesDataSource.open();
            moviesDataSource.create(createMovie("batman", "Nolan", 2006, "Action"));
            moviesDataSource.create(createMovie("batman2", "Nolan", 2008, "Action"));
            moviesDataSource.create(createMovie("batman3", "Nolan", 2010, "Action"));

            moviesDataSource.create(createMovie("Superman", "Jose", 2001, "Action"));
            moviesDataSource.create(createMovie("Spiderman", "Some Director", 1985, "Action"));
            moviesDataSource.create(createMovie("Aquaman", "El cuqui", 2015, "Action"));
            moviesDataSource.create(createMovie("Antman", "Robertito", 2011, "Action"));
            moviesDataSource.create(createMovie("Horseman", "Joey", 2003, "Action"));
            moviesDataSource.create(createMovie("Fantastic Four", "Josemir", 1996, "Action"));

            moviesDataSource.close();

        }catch(Exception e){
            //TODO
        }
    }

    private ContentValues createMovie(String title, String director, int year, String gender){
        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDatabaseHelper.COLUMN_NAME,title);
        contentValues.put(MyDatabaseHelper.COLUMN_GENDER,director);
        contentValues.put(MyDatabaseHelper.COLUMN_DIRECTOR,year);
        contentValues.put(MyDatabaseHelper.COLUMN_YEAR,gender);

        return contentValues;
    }



}
