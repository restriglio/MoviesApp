package base.apptrailers.mobile.globant.com.moviesapp.fragments;

import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.activities.MovieDetailActivity;
import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MoviesDataSource;
import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MyDatabaseHelper;
import base.apptrailers.mobile.globant.com.moviesapp.entity.Movie;

/**
 * Created by raul.striglio on 07/09/16.
 */
public class MovieDetailFragment extends Fragment {

    public static String TAG = "movieDetailFragment";

    private TextView title;
    private TextView director;
    private TextView year;
    private TextView gender;
    private View rootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_detail, container, false);

        title = (TextView) rootView.findViewById(R.id.title);
        director = (TextView) rootView.findViewById(R.id.director);
        year = (TextView) rootView.findViewById(R.id.year);
        gender = (TextView) rootView.findViewById(R.id.gender);

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle bundle = this.getArguments();
        long id = bundle.getLong(MovieDetailActivity.BUNDLE_ID);
        MoviesDataSource moviesDataSource = new MoviesDataSource(getActivity());

        moviesDataSource.open();
        String[] whereValue = {String.valueOf(id)};
        Cursor cursor = moviesDataSource.query(MoviesDataSource.allColumns, MyDatabaseHelper.COLUMN_ID + " =? ", whereValue);
        cursor.moveToFirst();
        Movie movie = moviesDataSource.cursorToMovie(cursor);
        cursor.close();
        moviesDataSource.close();

        title.setText(movie.getName());
        director.setText(movie.getDirector());
        year.setText(String.valueOf(movie.getYear()));
        gender.setText(movie.getGender());

    }
}
