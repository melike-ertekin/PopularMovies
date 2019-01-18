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

        Picasso.get().load(movieList.get(position).getImage()).into(holder.image);
        Log.i("image", movieList.get(position).getImage());
        holder.title.setText(movieList.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);

            image = itemView.findViewById(R.id.image);

        }

    }


}
