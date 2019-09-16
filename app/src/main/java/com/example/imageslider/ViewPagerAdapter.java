package com.example.imageslider;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "ViewPagerAdapter";

    private  ArrayList<ImageFragment> fragments = new ArrayList<>();
    private ArrayList<String> titles = new ArrayList<>();
    private City mselectedcity;

    public ViewPagerAdapter(FragmentManager fm,City city) {
        super(fm);
        titles.add("First");
       /* titles.add("Second");*/
        titles.add("Third");
        titles.add("Fourth");
        titles.add("Fifth");
        titles.add("Sixth");

        this.mselectedcity=city;
        for( int j=0;j<mselectedcity.getImageUrls().size();j++)
        {
            ImageFragment frag = new ImageFragment();
            Bundle b =new Bundle();
            b.putString("imageUrl",mselectedcity.getImageUrls().get(j));
            frag.setArguments(b);
            fragments.add(frag);
        }
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

}
