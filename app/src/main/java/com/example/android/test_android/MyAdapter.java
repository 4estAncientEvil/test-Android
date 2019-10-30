package com.example.android.test_android;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyAdapter extends FragmentPagerAdapter {
    public MyAdapter(FragmentManager mgr) {
        super(mgr);
    }
    @Override
    public int getCount() {
        return(MainActivity.getCount());
    }
    @Override
    public Fragment getItem(int position) {
        return(PageFragment.newInstance(position));
    }
}

