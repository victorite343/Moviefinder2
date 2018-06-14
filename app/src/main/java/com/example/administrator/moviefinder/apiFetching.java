package com.example.administrator.moviefinder;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class apiFetching {
    private final String API_KEY = "ad93cb428a9fe06b65d1ab357826d14b";
    private final String API_BASE_URL = "https://api.themoviedb.org/3/movie/157336?api_key=ad93cb428a9fe06b65d1ab357826d14b";
    private AsyncHttpClient client;

    public apiFetching(){

        this.client = new AsyncHttpClient();
    }

    private String getApiUrl (String relativeUrl){
        return API_BASE_URL + relativeUrl;
    }

    public void getMovies (JsonHttpResponseHandler handler){
        String url = getApiUrl("3/movie/157336?api_key=ad93cb428a9fe06b65d1ab357826d14b");
        RequestParams params = new RequestParams("ad93cb428a9fe06b65d1ab357826d14b", API_KEY);
        client.get(url, params, handler);
    }
}
