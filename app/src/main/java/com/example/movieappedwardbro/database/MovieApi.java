package com.example.movieappedwardbro.database;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieApi {

    private static final String BASE_URL = "https://api.themoviedb.org/3/discover/";

    public static MovieApiService create() {

        // Create an OkHttpClient to be able to make a log of the network traffic
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        // Create the Retrofit instance
        Retrofit numbersApi = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Return the Retrofit NumbersApiService
        return numbersApi.create(MovieApiService.class);
    }
}
