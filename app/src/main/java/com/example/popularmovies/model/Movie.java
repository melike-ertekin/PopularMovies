package com.example.popularmovies.model;

public class Movie {
    private String title;
    private String image;

    public Movie(String title, String image) {
        this.title = title;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }


    public String getImage() {
        return image;
    }
}
