package com.example.popularmovies.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("title")
    private String title;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String description;
    @SerializedName("vote_average")
    private double vote_avg;

    public Movie(String title, String poster, String releaseDate, String description, double vote_avg) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.poster = poster;
        this.description = description;
        this.vote_avg = vote_avg;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getPoster() {
        return poster;
    }

    public String getDescription() {
        return description;
    }

    public double getVote_avg() {
        return vote_avg;
    }
}
