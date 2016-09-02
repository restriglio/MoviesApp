package base.apptrailers.mobile.globant.com.moviesapp.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import base.apptrailers.mobile.globant.com.moviesapp.R;

/**
 * Created by raul.striglio on 01/09/16.
 */
public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<String> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView infoText;
        public CardView cardView;
        public ViewHolder(View v) {
            super(v);
            infoText = (TextView) v.findViewById(R.id.info_text);
            cardView = (CardView) v.findViewById(R.id.card_view);
        }
    }

    public MoviesAdapter(List<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_detail, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.infoText.setText(mDataset.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
