package com.example.sony.sample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sony.sample.screen.BlankFragment;
import com.example.sony.sample.screen.MovieFragment;

/**
 * Created by Sony on 12/15/2017.
 */

public class PagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                MovieFragment mf = new MovieFragment();
                return mf;
            case 1:
                BlankFragment bl1 = new BlankFragment();
                return bl1;
            case 2:
                BlankFragment bl2 = new BlankFragment();
                return bl2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
