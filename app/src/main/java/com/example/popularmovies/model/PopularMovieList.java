package com.example.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PopularMovieList {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
