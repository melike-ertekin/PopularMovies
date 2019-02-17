package com.example.popularmovies.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.popularmovies.MovieAdapter;
import com.example.popularmovies.R;
import com.example.popularmovies.api.GetHighestRatedMoviesService;
import com.example.popularmovies.api.GetPopularMoviesService;
import com.example.popularmovies.api.RetrofitInstance;
import com.example.popularmovies.model.MovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<MovieList> popularMovieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_movie_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);


        mLayoutManager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        getPopularMovies();

    }

    private void getPopularMovies() {


        /*Create handle for the RetrofitInstance interface*/
        GetPopularMoviesService popularMoviesService = RetrofitInstance.getRetrofitInstance().create(GetPopularMoviesService.class);


        Call<MovieList> call = popularMoviesService.getPopularMoviesData(1);

        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if (response.isSuccessful()) {
                    MovieList pml = response.body();
                    Log.d("heyt", pml.getMovies().get(0).getTitle());
                    mAdapter = new MovieAdapter(getApplicationContext(), pml.getMovies());
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                showErrorMessage();
            }
        });
    }

    private void getHighestRatedMovies() {


        /*Create handle for the RetrofitInstance interface*/
        GetHighestRatedMoviesService highestRatedMoviesService = RetrofitInstance.getRetrofitInstance().create(GetHighestRatedMoviesService.class);


        Call<MovieList> call = highestRatedMoviesService.getHighestRatedMoviesData(1);

        call.enqueue(new Callback<MovieList>() {
            @Override
            public void onResponse(Call<MovieList> call, Response<MovieList> response) {
                if (response.isSuccessful()) {
                    MovieList pml = response.body();
                    Log.d("heyt", pml.getMovies().get(0).getTitle());
                    mAdapter = new MovieAdapter(getApplicationContext(), pml.getMovies());
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<MovieList> call, Throwable t) {
                showErrorMessage();
            }
        });
    }


    public void showErrorMessage() {

        Toast.makeText(MainActivity.this, "Network Issue", Toast.LENGTH_LONG).show();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItem = item.getItemId();

        if (menuItem == R.id.popular_movies) {
            item.setShowAsAction(1);
            getPopularMovies();
            //Toast.makeText(MainActivity.this, "popular_movies clicked", Toast.LENGTH_LONG).show();
        } else if (menuItem == R.id.highest_rated_movies) {
            item.setShowAsAction(1);
            getHighestRatedMovies();
            // Toast.makeText(MainActivity.this, "highest_rated_movies clicked", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
