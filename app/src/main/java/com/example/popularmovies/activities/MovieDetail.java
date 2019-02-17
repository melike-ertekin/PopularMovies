package com.example.popularmovies.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.example.popularmovies.R;
import com.example.popularmovies.api.MovieServiceSettings;
import com.example.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

public class MovieDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.movieDetailToolbar);
        setSupportActionBar(toolbar);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }







        Bundle extras = getIntent().getExtras();
        Movie m = (Movie) getIntent().getSerializableExtra("SELECTED_MOVIE");

        Log.i("Movie_detail", m.getTitle());


        TextView title = findViewById(R.id.title);
        TextView description = findViewById(R.id.description);
        TextView average_vote = findViewById(R.id.average_vote);
        TextView release_date = findViewById(R.id.release_date);
        ImageView poster = findViewById(R.id.poster);

        Picasso.get().load(MovieServiceSettings.IMAGE_BASE_URL + m.getPoster()).into(poster);
        toolbar.setTitle(m.getTitle());
        title.setText(m.getTitle());
        description.setText(m.getDescription());
        average_vote.setText(String.valueOf(m.getVote_avg()));
        release_date.setText(m.getReleaseDate());
    }

}
