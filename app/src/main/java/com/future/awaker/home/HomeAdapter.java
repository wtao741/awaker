package com.future.awaker.home;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.future.awaker.news.NewListFragment;
import com.future.awaker.video.VideoListFragment;

import java.util.List;

/**
 * Copyright ©2017 by Teambition
 */

public class HomeAdapter extends FragmentPagerAdapter {

    private List<String> titles;
    private VideoListFragment videoListFragment;

    public HomeAdapter(FragmentManager fm, List<String> titles) {
        super(fm);
        this.titles = titles;
    }

    public void setCat(int cat) {
        if (videoListFragment != null) {
            videoListFragment.setCat(cat);
        }
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = HomeListFragment.newInstance();
                break;
            case 1:
                fragment = NewListFragment.newInstance(0);
                break;
            case 2:
                videoListFragment = VideoListFragment.newInstance();
                fragment = videoListFragment;
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return titles == null ? 0 : titles.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
