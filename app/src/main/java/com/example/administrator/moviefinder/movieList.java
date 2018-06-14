package com.example.administrator.moviefinder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class movieList implements Serializable {
    private String title;
    private int id;
    private String overview;
    private String poster_path;
    private int vote_average;
    private ArrayList<String> castList;
    private static final long serialVersionUID = -8959832007991513854L;
    private String largePosterUrl;
    private String criticsConsensus;
    private int audienceScore;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getOverview() {
        return overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public int getVote_average() {
        return vote_average;
    }

    public ArrayList<String> getCastList() {
        return castList;
    }

    public static movieList fromJson(JSONObject jsonObject){
    movieList b = new movieList();
        try {

        b.title = jsonObject.getString("title");
        b.id = jsonObject.getInt("id");
        b.overview = jsonObject.getString("overview");
        b.poster_path = jsonObject.getJSONObject("posters").getString("thumbnail");
        b.vote_average = jsonObject.getJSONObject("ratings").getInt("critics_score");
        b.castList = new ArrayList<String>();
        b.largePosterUrl = jsonObject.getJSONObject("posters").getString("detailed");
        b.criticsConsensus = jsonObject.getString("critics_consensus");
        b.audienceScore = jsonObject.getJSONObject("ratings").getInt("audience_score");

        JSONArray abridgedCast = jsonObject.getJSONArray("abridged_cast");

        for (int i = 0; i < abridgedCast.length(); i++) {
            b.castList.add(abridgedCast.getJSONObject(i).getString("name"));
        }
    } catch (JSONException e) {
        e.printStackTrace();
        return null;
    }
        return b;
    }

    public static ArrayList<movieList> fromJson(JSONArray jsonArray){

        ArrayList<movieList> movies = new ArrayList<movieList>(jsonArray.length());

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject moviesJson = null;
            try {
                moviesJson = jsonArray.getJSONObject(i);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }

            movieList movie = movieList.fromJson(moviesJson);
            if (movie != null) {
                movies.add(movie);
            }
        }

        return movies;
    }

    public String getLargePosterUrl() {
        return largePosterUrl;
    }

    public String getCriticsConsensus() {
        return criticsConsensus;
    }

    public int getAudienceScore() {
        return audienceScore;
    }
}
