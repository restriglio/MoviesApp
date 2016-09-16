package base.apptrailers.mobile.globant.com.moviesapp.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.fragments.MovieDetailFragment;

/**
 * Created by raul.striglio on 08/09/16.
 */
public class MovieDetailActivity extends Activity {

    public static String BUNDLE_DIRECTOR = "name";
    public static String BUNDLE_TITLE = "title";
    public static String BUNDLE_GENDER = "gender";
    public static String BUNDLE_YEAR = "year";
    public static String BUNDLE_EXTRA = "extra";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Bundle bundle = getIntent().getBundleExtra(BUNDLE_EXTRA);
        MovieDetailFragment movieDetailFragment = MovieDetailFragment.newInstance();
        movieDetailFragment.setArguments(bundle);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contentPanel, movieDetailFragment, movieDetailFragment.TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        ft.commit();
    }

    public static void start(Context c, String name, String director, int year, String gender) {
        Bundle bundle = new Bundle();

        bundle.putString(BUNDLE_TITLE, name);
        bundle.putString(BUNDLE_DIRECTOR, director);
        bundle.putInt(BUNDLE_YEAR, year);
        bundle.putString(BUNDLE_GENDER, gender);

        Intent intent = new Intent(c, MovieDetailActivity.class);
        intent.putExtra(BUNDLE_EXTRA, bundle);
        c.startActivity(intent);
    }
}
