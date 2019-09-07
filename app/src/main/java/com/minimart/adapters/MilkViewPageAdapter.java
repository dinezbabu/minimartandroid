package com.minimart.adapters;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.minimart.fragments.MilkFragment;

public class MilkViewPageAdapter extends FragmentPagerAdapter {

    public MilkViewPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        MilkFragment milkFragment = new MilkFragment();
        i=i+1;
        Bundle milkBundle= new Bundle();
        milkBundle.putString("Milk","Milk"+i);
        milkFragment.setArguments(milkBundle);
        return milkFragment;
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        position = position+1;
        return "Milk"+position;
    }
}
