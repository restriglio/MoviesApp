package base.apptrailers.mobile.globant.com.moviesapp.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import base.apptrailers.mobile.globant.com.moviesapp.R;
import base.apptrailers.mobile.globant.com.moviesapp.activities.MovieDetailActivity;
import base.apptrailers.mobile.globant.com.moviesapp.entity.Movie;

/**
 * Created by raul.striglio on 01/09/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> mDataset;
    private View.OnClickListener listener;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView infoText;
        public TextView movieId;
        public CardView cardView;

        public ViewHolder(View v) {
            super(v);
            infoText = (TextView) v.findViewById(R.id.info_text);
            movieId = (TextView) v.findViewById(R.id.movie_id);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public MoviesAdapter(List<Movie> myDataset, Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.infoText.setText(mDataset.get(position).getName());
        holder.movieId.setText(String.valueOf(mDataset.get(position).getId()));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MovieDetailActivity.start(context,mDataset.get(position).getId());
            }
        };

        holder.itemView.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
