package id.web.komatikugm.moviedb;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    public static String DB_API = "6949d351d7dc8e092c674d3dbd76a1e0";

    @GET("popular?api_key="+DB_API)
    Call<Movie> getPopular();

    @GET("top_rated?api_key="+DB_API)
    Call<Movie> getTopRated();

}
