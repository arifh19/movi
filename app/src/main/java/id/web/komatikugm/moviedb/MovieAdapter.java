package id.web.komatikugm.moviedb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    List<Result> results;

    public MovieAdapter(List<Result> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_movie, viewGroup, false);
        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieHolder movieHolder, final int position) {
        Picasso.with(movieHolder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/"+results.get(position).getPosterPath())
                .into(movieHolder.Poster);
        movieHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Result data = results.get(position);
                Intent i = new Intent(movieHolder.itemView.getContext(),DetailMovie.class);
                i.putExtra("movie", new GsonBuilder().create().toJson(data));
                movieHolder.itemView.getContext().startActivity(i);
            }
        });
    }

    public void setData(List<Result>results){
        this.results =results;
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class MovieHolder extends RecyclerView.ViewHolder{
        ImageView Poster;
        public MovieHolder(View itemView) {
            super(itemView);
            Poster = (ImageView)itemView.findViewById(R.id.poster);
        }
    }
}
