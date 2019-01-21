package com.example.popularmovies.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {


    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.themoviedb.org/3/";


    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    /*
    public static GetPopularMoviesService getClient() {


        // change your base URL
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        Log.i("red", "dsaa");
        //Creating object for our interface
        GetPopularMoviesService api = retrofit.create(GetPopularMoviesService.class);
        return api; // return the APIInterface object
    }
*/
}