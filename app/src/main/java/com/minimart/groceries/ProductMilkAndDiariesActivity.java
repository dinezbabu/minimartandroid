package com.minimart.groceries;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.minimart.adapters.MilkViewPageAdapter;

public class ProductMilkAndDiariesActivity extends AppCompatActivity {

    private ViewPager milkViewPager;
    private MilkViewPageAdapter milkViewPageAdapter;
    private TabLayout milkTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_milk_and_dairies);
        Toolbar toolbar = findViewById(R.id.arrow_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Milk & Dairy Product");

        milkViewPager = findViewById(R.id.pager_milk_and_diaries);
        milkViewPageAdapter= new MilkViewPageAdapter(getSupportFragmentManager());
        milkViewPager.setAdapter(milkViewPageAdapter);

        milkTabLayout = findViewById(R.id.tabs_milk);
        milkTabLayout.setupWithViewPager(milkViewPager);


    }
}
