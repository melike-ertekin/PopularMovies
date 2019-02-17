package com.example.popularmovies;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.popularmovies.activities.MovieDetail;
import com.example.popularmovies.api.MovieServiceSettings;
import com.example.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;
/**
 * {@link MovieAdapter} is a {@link RecyclerView.Adapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Movie} objects.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<Movie> movieList;
    private int selectedMovieIndex;

    public MovieAdapter(Context ctx, List<Movie> moviesModelArrayList) {

        inflater = LayoutInflater.from(ctx);
        this.movieList = moviesModelArrayList;
    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.movie_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MovieAdapter.MyViewHolder holder, int position) {
        Log.i("image", MovieServiceSettings.IMAGE_BASE_URL + movieList.get(position).getPoster());
        Picasso.get().load(MovieServiceSettings.IMAGE_BASE_URL + movieList.get(position).getPoster()).into(holder.poster);

        //Picasso.get().setLoggingEnabled(true);
        // Glide.with(holder.itemView)
        //       .load(IMAGE_BASE_URL + movieList.get(position).getPoster())
        //       .apply(RequestOptions.placeholderOf(R.color.colorPrimary))
        //      .into(holder.poster);


    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView poster;

        public MyViewHolder(View itemView) {
            super(itemView);


            poster = itemView.findViewById(R.id.poster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Context context = v.getContext();
                    Intent intent = new Intent(context, MovieDetail.class);
                    intent.putExtra("SELECTED_MOVIE", movieList.get(getAdapterPosition()));
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });

        }

    }


}
