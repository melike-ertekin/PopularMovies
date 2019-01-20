package com.example.popularmovies.api;

import com.example.popularmovies.model.PopularMovieList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {


    // for GET request
// UserListResponse is POJO class to get the data from API, we use List<UserListResponse> in callback because the data in our API is starting from JSONArray
    String POPULAR_MOVIES_REQUEST = "movie/popular?api_key=WRITE YOUR API KEY";

    @GET(POPULAR_MOVIES_REQUEST)
    Call<PopularMovieList> popularMovies(
            @Query("page") int page
    );

}
