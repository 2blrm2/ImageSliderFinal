package com.example.imageslider;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "ViewPagerAdapter";

    private  ArrayList<ImageFragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        titles.add("First");
        titles.add("Second");
        titles.add("Third");
        titles.add("Fourth");
    }

    @Nullable
    @Override
    //title...
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void setFragments(ArrayList<ImageFragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }
}
