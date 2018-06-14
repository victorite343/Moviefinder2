package com.example.administrator.moviefinder;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivityMovieFinder extends AppCompatActivity {

    private ListView lvMovies;
    private PopularMovies adapterMovies;
    apiFetching client;
    public static final String MOVIE_DETAIL_KEY = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_movie_finder);

        lvMovies = (ListView) findViewById(R.id.lvMovies);
        ArrayList<movieList> aMovies = new ArrayList<movieList>();
        adapterMovies = new PopularMovies(this, aMovies);
        lvMovies.setAdapter(adapterMovies);

        fetchPopularMovies();
        setupMovieSelectedListener();
    }

    public void setupMovieSelectedListener() {
        lvMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long rowId) {
                Intent i = new Intent(MainActivityMovieFinder.this, MovieDetails.class);
                i.putExtra(MOVIE_DETAIL_KEY, adapterMovies.getItem(position));
                startActivity(i);
            }
        });
    }

    private void fetchPopularMovies() {
        client = new apiFetching();
        client.getMovies(new JsonHttpResponseHandler() {


            public void onSuccess(int statusCode, PreferenceActivity.Header[] headers, JSONObject responseBody) {
                JSONArray items = null;
                try {
                    items = responseBody.getJSONArray("movies");
                    ArrayList<movieList> movies = movieList.fromJson(items);

                    for (movieList movie : movies) {
                        adapterMovies.add(movie);
                    }
                    adapterMovies.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
