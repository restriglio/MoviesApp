package base.apptrailers.mobile.globant.com.moviesapp.Activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import base.apptrailers.mobile.globant.com.moviesapp.Fragments.MovieListFragment;
import base.apptrailers.mobile.globant.com.moviesapp.R;

/**
 * Created by raul.striglio on 01/09/16.
 */
public class MainActivity extends Activity {

    private RelativeLayout showRelative;
    private FrameLayout contentPanel;
    private MovieListFragment movieListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showRelative = (RelativeLayout)findViewById(R.id.showRelative);
    }

    @Override
    protected void onStart() {
        super.onStart();
        showRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movieListFragment = MovieListFragment.newInstance();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.contentPanel, movieListFragment, movieListFragment.TAG);
                ft.addToBackStack(movieListFragment.TAG);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                ft.commit();
            }
        });
    }
}
