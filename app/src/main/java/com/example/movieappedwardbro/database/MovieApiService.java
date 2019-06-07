package com.example.movieappedwardbro.database;


import com.example.movieappedwardbro.BuildConfig;
import com.example.movieappedwardbro.model.MoviesList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    String apiKey = BuildConfig.apiKey;

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=true&with_original_language=en")
    Call<MoviesList> getMovies();

    @GET("movie?api_key=" + apiKey + "&language=en-US&sort_by=popularity.desc&with_original_language=en")
    Call<MoviesList> getMovieYear(@Query("year") String year);

}