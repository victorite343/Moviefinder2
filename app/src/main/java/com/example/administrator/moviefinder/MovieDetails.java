package com.example.administrator.moviefinder;

import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetails extends MainActivityMovieFinder{
    private ImageView ivPosterImage;
    private TextView tvTitle;
    private TextView tvSynopsis;
    private TextView tvCast;
    private TextView tvAudienceScore;
    private TextView tvCriticsScore;
    private TextView tvCriticsConsensus;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moviedetails);

        ivPosterImage = (ImageView) findViewById(R.id.ivPosterImage);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvSynopsis = (TextView) findViewById(R.id.tvSynopsis);
        tvCast = (TextView) findViewById(R.id.tvCast);
        tvCriticsConsensus = (TextView) findViewById(R.id.tvCriticsConsensus);
        tvAudienceScore =  (TextView) findViewById(R.id.tvAudienceScore);
        tvCriticsScore = (TextView) findViewById(R.id.tvCriticsScore);

        movieList movie = (movieList) getIntent().getSerializableExtra(MainActivityMovieFinder.MOVIE_DETAIL_KEY);
        loadMovie(movie);
    }


    public void loadMovie(movieList movie) {

        tvTitle.setText(movie.getTitle());
        tvCriticsScore.setText(Html.fromHtml("<b>Critics Score:</b> " + movie.getVote_average() + "%"));
        tvAudienceScore.setText(Html.fromHtml("<b>Audience Score:</b> " + movie.getAudienceScore() + "%"));
        tvCast.setText((CharSequence) movie.getCastList());
        tvSynopsis.setText(Html.fromHtml("<b>Synopsis:</b> " + movie.getOverview()));
        tvCriticsConsensus.setText(Html.fromHtml("<b>Consensus:</b> " + movie.getCriticsConsensus()));

        Picasso.with(this).load(movie.getLargePosterUrl()).placeholder(R.drawable.largemovieimg).into(ivPosterImage);
    }
}
