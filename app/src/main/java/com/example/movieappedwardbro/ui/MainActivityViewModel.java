package com.example.movieappedwardbro.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.movieappedwardbro.database.MovieRepository;
import com.example.movieappedwardbro.model.Movie;
import com.example.movieappedwardbro.model.MoviesList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private MovieRepository movieRepository = new MovieRepository();

    private MutableLiveData<List<Movie>> movie = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getError() {
        return error;
    }

    public MutableLiveData<List<Movie>> getMovie() {
        return movie;
    }

    public void getMovies() {
        movieRepository
                .getMovies()
                .enqueue(new Callback<MoviesList>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviesList> call, @NonNull Response<MoviesList> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            movie.setValue(response.body().getResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<MoviesList> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }

    public void getMovieYear(String year) {
        movieRepository
                .getMovieYear(year)
                .enqueue(new Callback<MoviesList>() {
                    @Override
                    public void onResponse(@NonNull Call<MoviesList> call, @NonNull Response<MoviesList> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            movie.setValue(response.body().getResults());
                        } else {
                            error.setValue("Api Error: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<MoviesList> call, @NonNull Throwable t) {
                        error.setValue("Api Error: " + t.getMessage());
                    }
                });
    }

}

