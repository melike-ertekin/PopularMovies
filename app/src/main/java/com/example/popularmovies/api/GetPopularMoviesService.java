package com.example.popularmovies.api;

import com.example.popularmovies.model.MovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * {@link GetPopularMoviesService} includes http call to get popular movies.
 */
public interface GetPopularMoviesService {


    String POPULAR_MOVIES_REQUEST = "movie/popular?api_key=" + MovieServiceSettings.API_KEY;

    @GET(POPULAR_MOVIES_REQUEST)
    Call<MovieList> getPopularMoviesData(
            @Query("page") int page
    );

}
