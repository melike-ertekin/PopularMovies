package com.example.popularmovies.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * {@link MovieList} list of movies
 *
 */
public class MovieList {

    @SerializedName("results")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }
}
