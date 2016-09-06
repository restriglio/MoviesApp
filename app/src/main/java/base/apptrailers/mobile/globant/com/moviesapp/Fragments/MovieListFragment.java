package base.apptrailers.mobile.globant.com.moviesapp.Fragments;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import base.apptrailers.mobile.globant.com.moviesapp.Adapters.MoviesAdapter;
import base.apptrailers.mobile.globant.com.moviesapp.R;

/**
 * Created by raul.striglio on 01/09/16.
 */
public class MovieListFragment extends Fragment {

    public String TAG = "movieListFragment";
    private View rootView;
    private RecyclerView recyclerView;
    private MoviesAdapter listAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<String> myDataset;
    protected RecyclerView.ItemDecoration itemDecoration;

    public static MovieListFragment newInstance() {

        Bundle args = new Bundle();

        MovieListFragment fragment = new MovieListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.movie_list_fragment,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(), OrientationHelper.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        myDataset = Arrays.asList("Movie1","Movie2","Movie3","Movie4","Movie5","Movie6","Movie7","Movie8","Movie9","Movie10","Movie11","Movie12","Movie13");
        listAdapter = new MoviesAdapter(myDataset);
        recyclerView.setAdapter(listAdapter);

        return rootView;
    }



}
