package com.minimart.groceries;

import android.app.Activity;
import android.content.Intent;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.minimart.adapters.CategoryAdapter;
import com.minimart.models.Category;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private Button scanBtn;
    private TextView formatTxt, contentTxt;
    private SearchView searchView;
    List<Category> listCategoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        listCategoryList = new ArrayList<>();
        listCategoryList.add(new Category("Biscuit","Biscuit","Biscuit",R.drawable.category_biscuits));
        listCategoryList.add(new Category("Drinks","Drinks","Drinks",R.drawable.category_drinks));
        listCategoryList.add(new Category("Grocery & Staples","Grocery & Staples","Grocery & Staples",R.drawable.category_grocerystaples));
        listCategoryList.add(new Category("Oats","Oats","Oats",R.drawable.category_oats));
        listCategoryList.add(new Category("Oil","Oil","Oil",R.drawable.category_oil));
        listCategoryList.add(new Category("Beverages","Beverages","Beverages",R.drawable.category_teacoffe));
        RecyclerView recyclerView = findViewById(R.id.recycler_category);
        CategoryAdapter categoryAdapter = new CategoryAdapter(this,listCategoryList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(categoryAdapter);


        drawerLayout = findViewById(R.id.activity_main);

        searchView=(SearchView) findViewById(R.id.txtSearch);
        searchView.setIconifiedByDefault(false);
       searchView.setQueryHint("Search minimart products");

        final ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            //formatTxt.setText("FORMAT: " + scanFormat);
            //contentTxt.setText("CONTENT: " + scanContent);
            searchView.setQuery(scanContent,false);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
