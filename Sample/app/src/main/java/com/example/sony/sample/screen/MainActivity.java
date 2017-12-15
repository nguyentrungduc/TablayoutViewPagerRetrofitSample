package com.example.sony.sample.screen;

import android.os.AsyncTask;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sony.sample.PagerAdapter;
import com.example.sony.sample.R;
import com.example.sony.sample.data.api.MovieApi;
import com.example.sony.sample.data.model.Movie;
import com.example.sony.sample.data.model.Respone;
import com.example.sony.sample.utils.Constant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.toString();
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getData();


    }

    private void initView(){
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout.addTab(tabLayout.newTab().setText("1"));
        tabLayout.addTab(tabLayout.newTab().setText("2"));
        tabLayout.addTab(tabLayout.newTab().setText("3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        final PagerAdapter adapter = new PagerAdapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    private void getData(){
        new MovieApi().getMovieService().getPopularMovie(Constant.API_KEY_V3, "en-US","1").enqueue(new Callback<Respone>() {
            @Override
            public void onResponse(Call<Respone> call, Response<Respone> response) {
                Log.d(TAG, response.body().toString());
                Log.d(TAG,call.toString());
            }

            @Override
            public void onFailure(Call<Respone> call, Throwable t) {

            }
        });

        new GetAsync().execute(new MovieApi().getMovieService().getPopularMovie(Constant.API_KEY_V3, "en-US","1"));
    }

    private class GetAsync extends AsyncTask<Call, Void, List<Movie>> {

        @Override
        protected List<Movie> doInBackground(Call... params) {
            try {
                Call<Respone> call = params[0];
                Response<Respone> response = call.execute();
                List<Movie> movieList = new ArrayList<>();

                for(Movie movie : response.body().getResults()){
                    movieList.add(movie);
                }
                return movieList;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Movie> result) {
            Log.d(TAG, result.toString());

        }


    }

}
