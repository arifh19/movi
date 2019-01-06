package id.web.komatikugm.moviedb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

public class DetailMovie extends AppCompatActivity {

    ImageView Poster;
    TextView Judul, Rating, Tgl, Overview;
    Result result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        Poster = (ImageView)findViewById(R.id.poster);
        Judul = (TextView)findViewById(R.id.judul);
        Rating = (TextView)findViewById(R.id.rating);
        Tgl = (TextView)findViewById(R.id.tgl);
        Overview = (TextView)findViewById(R.id.overview);

        result = new GsonBuilder()
                .create()
                .fromJson(getIntent().getStringExtra("movie"),Result.class);
        Picasso.with(DetailMovie.this).load("http://image.tmdb.org/t/p/w185/"+result.getPosterPath()).into(Poster);
        Judul.setText("Movie Title \n"+result.getTitle());
        Rating.setText("Vote Average : "+Double.toString(result.getVoteAverage()));
        Tgl.setText("Release Date \n "+result.getReleaseDate());
        Overview.setText("Overview"+result.getOverview());
    }
}
