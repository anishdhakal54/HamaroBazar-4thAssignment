package com.anish.hamrobazarapi.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.anish.hamrobazarapi.R;

import java.util.ArrayList;
import java.util.List;

public class viewpagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList = new ArrayList<>();

    public viewpagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
    //Add the fragment and title to the list
    public void addFragment(Fragment fragment){
        fragmentList.add(fragment);
    }
}