package com.example.popularmovies.modal;

public class Movie {
    private String title;
    private String releaseDate;
    private String poster;
    private String description;
    private String vote_avg;

    public Movie(String title, String poster, String releaseDate, String description, String vote_avg) {
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

    public String getVote_avg() {
        return vote_avg;
    }
}
