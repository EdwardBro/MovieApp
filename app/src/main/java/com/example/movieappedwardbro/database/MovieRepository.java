package com.example.movieappedwardbro.database;

import com.example.movieappedwardbro.model.MoviesList;

import retrofit2.Call;

public class MovieRepository {

    private MovieApiService movieApiService = MovieApi.create();

    public Call<MoviesList> getMovies() {
        return movieApiService.getMovies();
    }

    public Call<MoviesList> getMovieYear(String year) {
        return movieApiService.getMovieYear(year);
    }

}

