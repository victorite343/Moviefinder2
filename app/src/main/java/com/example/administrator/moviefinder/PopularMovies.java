package com.example.administrator.moviefinder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PopularMovies extends ArrayAdapter<movieList> {

    public PopularMovies(Context context, ArrayList<movieList> aMovie) {
        super(context, 0, (List<movieList>) aMovie);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        movieList movie = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.movie_items, parent, false);
        }

        TextView mTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView mCriticsScore = (TextView) convertView.findViewById(R.id.tvVote_average);
        TextView mCast = (TextView) convertView.findViewById(R.id.tvCast);
        ImageView mPosterImage = (ImageView) convertView.findViewById(R.id.PosterImage);

        mTitle.setText(movie.getTitle());
        mCriticsScore.setText("Score: " + movie.getOverview() + "%");
        mCast.setText((CharSequence) movie.getCastList());
        Picasso.with(getContext()).load(movie.getPoster_path()).into(mPosterImage);

        return convertView;
    }
}
