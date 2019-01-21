package com.example.popularmovies.api;

import com.example.popularmovies.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetHighestRatedMoviesService {

    String HIGHEST_RATED_MOVIES_REQUEST = "movie/top_rated?api_key=" + MovieServiceSettings.API_KEY;

    @GET(HIGHEST_RATED_MOVIES_REQUEST)
    Call<MovieList> getHighestRatedMoviesData(
            @Query("page") int page
    );
}
