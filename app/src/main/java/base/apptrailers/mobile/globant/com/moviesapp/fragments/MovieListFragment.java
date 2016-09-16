package base.apptrailers.mobile.globant.com.moviesapp.fragments;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import base.apptrailers.mobile.globant.com.moviesapp.adapters.MoviesAdapter;
import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.dataresources.MoviesDataSource;
import base.apptrailers.mobile.globant.com.moviesapp.entity.Movie;

/**
 * Created by raul.striglio on 01/09/16.
 */
public class MovieListFragment extends Fragment {

    public String TAG = "movieListFragment";
    private View rootView;
    private RecyclerView recyclerView;
    private MoviesAdapter MoviesAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Movie> myDataset;
    private MoviesDataSource moviesDataSource;

    public static MovieListFragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();
        return fragment;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_list_fragment, container, false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();

        moviesDataSource = new MoviesDataSource(getActivity());
        moviesDataSource.open();
        myDataset = moviesDataSource.getAllMovies();
        MoviesAdapter = new MoviesAdapter(myDataset, getActivity());
        recyclerView.setAdapter(MoviesAdapter);
    }
}
