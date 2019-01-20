package com.example.popularmovies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.popularmovies.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/w500";
    private LayoutInflater inflater;
    private List<Movie> movieList;

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
        Log.i("image", IMAGE_BASE_URL + movieList.get(position).getPoster());
        Picasso.get().load(IMAGE_BASE_URL + movieList.get(position).getPoster()).into(holder.poster);
        // Log.i("tit", movieList.get(position).getTitle());
        holder.title.setText(movieList.get(position).getTitle());
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

        TextView title;
        ImageView poster;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);

            poster = itemView.findViewById(R.id.poster);

        }

    }


}
