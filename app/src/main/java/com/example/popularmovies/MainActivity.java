package com.example.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.popularmovies.modal.Movie;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_movie_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);


        List<Movie> movies = new ArrayList();
        movies.add(new Movie("Harry Potter", "https://vignette.wikia.nocookie.net/harrypotter/images/c/c0/ALOExwKoxdkdeBvVi7NkaFl5Wa5.jpg/revision/latest?cb=20130803163017", "", "", ""));
        movies.add(new Movie("Harry Potter", "https://vignette.wikia.nocookie.net/harrypotter/images/c/c0/ALOExwKoxdkdeBvVi7NkaFl5Wa5.jpg/revision/latest?cb=20130803163017", "", "", ""));
        // specify an adapter (see also next example)
        mAdapter = new MovieAdapter(this, movies);
        mRecyclerView.setAdapter(mAdapter);

    }

}
