package base.apptrailers.mobile.globant.com.moviesapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.activities.MovieDetailActivity;

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


    public static MovieDetailFragment newInstance() {
        MovieDetailFragment fragment = new MovieDetailFragment();
        return fragment;
    }

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
        title.setText(bundle.getString(MovieDetailActivity.BUNDLE_TITLE));
        director.setText(bundle.getString(MovieDetailActivity.BUNDLE_DIRECTOR));
        year.setText(String.valueOf(bundle.getInt(MovieDetailActivity.BUNDLE_YEAR)));
        gender.setText(bundle.getString(MovieDetailActivity.BUNDLE_GENDER));

    }
}
