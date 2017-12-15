package com.example.sony.sample.data.api;

import com.example.sony.sample.data.model.Respone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Sony on 12/15/2017.
 */

public interface MovieService {
    @GET("movie/popular")
    Call<Respone> getPopularMovie(@Query("api_key") String api_key, @Query("language") String language, @Query("page") String page );
}
