package com.example.sony.sample;

import android.app.Application;

import com.example.sony.sample.data.api.MovieApi;
import com.example.sony.sample.data.model.Movie;
import com.example.sony.sample.utils.NetWorkManager;

/**
 * Created by Sony on 12/15/2017.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        MovieApi.init();
        NetWorkManager.init(this);
    }
}
