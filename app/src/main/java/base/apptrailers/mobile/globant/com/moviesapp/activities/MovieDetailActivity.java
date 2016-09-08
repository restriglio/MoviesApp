package base.apptrailers.mobile.globant.com.moviesapp.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.PersistableBundle;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.fragments.MovieDetailFragment;

/**
 * Created by raul.striglio on 08/09/16.
 */
public class MovieDetailActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail_activity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        MovieDetailFragment movieDetailFragment = MovieDetailFragment.newInstance();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.contentPanel, movieDetailFragment, movieDetailFragment.TAG);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
        ft.commit();
    }
}
