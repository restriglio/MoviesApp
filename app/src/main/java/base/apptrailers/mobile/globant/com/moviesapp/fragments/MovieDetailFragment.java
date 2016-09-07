package base.apptrailers.mobile.globant.com.moviesapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import base.apptrailers.mobile.globant.com.moviesapp.R;

/**
 * Created by raul.striglio on 07/09/16.
 */
public class MovieDetailFragment extends Fragment {

    public String TAG = "movieDetailFragment";
    private View rootView;

    public static MovieDetailFragment newInstance() {
        MovieDetailFragment fragment = new MovieDetailFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_detail, container, false);
        return rootView;
    }
}
