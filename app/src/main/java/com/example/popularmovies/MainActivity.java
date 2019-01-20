package com.example.popularmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.popularmovies.api.Api;
import com.example.popularmovies.model.PopularMovieList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<PopularMovieList> popularMovieData;

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

        getPopularMovies();


        // List<Movie> movies = new ArrayList();
        //  movies.add(new Movie("Harry Potter", "https://vignette.wikia.nocookie.net/harrypotter/images/c/c0/ALOExwKoxdkdeBvVi7NkaFl5Wa5.jpg/revision/latest?cb=20130803163017", "", "", ""));
        // movies.add(new Movie("Harry Potter", "https://vignette.wikia.nocookie.net/harrypotter/images/c/c0/ALOExwKoxdkdeBvVi7NkaFl5Wa5.jpg/revision/latest?cb=20130803163017", "", "", ""));
        // specify an adapter (see also next example)


    }

    private void getPopularMovies() {

        // Api is a class in which we define a method getClient() that returns the API Interface class object
        // registration is a POST request type method in which we are sending our field's data
        // enqueue is used for callback response and error

        Api.getClient().popularMovies(1).enqueue(new Callback<PopularMovieList>() {
            @Override
            public void onResponse(Call<PopularMovieList> call, Response<PopularMovieList> response) {
                Log.d("yep", "Returned count ");
                // if(response.isSuccessful()){
                PopularMovieList pml = response.body();
                Log.d("heyt", pml.getMovies().get(0).getTitle());
                mAdapter = new MovieAdapter(getApplicationContext(), pml.getMovies());
                mRecyclerView.setAdapter(mAdapter);
                // }
            }

            @Override
            public void onFailure(Call<PopularMovieList> call, Throwable t) {
                //showErrorMessage();
                Log.d("heyy", "error loading from API");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuItem = item.getItemId();
        if (menuItem == R.id.action_search)
            Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }
}
