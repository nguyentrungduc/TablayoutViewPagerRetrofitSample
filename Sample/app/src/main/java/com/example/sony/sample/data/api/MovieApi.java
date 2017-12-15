package com.example.sony.sample.data.api;

import com.example.sony.sample.data.model.Movie;
import com.example.sony.sample.utils.Constant;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sony on 12/15/2017.
 */

public class MovieApi {
    private static MovieApi instance = null;

    private MovieService movieService;

    public static MovieApi init() {
        if (instance == null) {
            instance = new MovieApi();
        }

        return instance;
    }

    public static MovieApi getInstance(){
        return instance;
    }


    public MovieApi() {

        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL).
                        addConverterFactory(GsonConverterFactory.create()).build();


        this.movieService = retrofit.create(MovieService.class);
    }

    public MovieService getMovieService() {
        return this.movieService;
    }
}
