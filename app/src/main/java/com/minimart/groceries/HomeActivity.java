package com.minimart.groceries;

import android.content.Intent;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
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
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.minimart.adapters.CategoryAdapter;
import com.minimart.interfaces.OnItemClickListener;
import com.minimart.models.Category;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements OnClickListener, BottomNavigationView.OnNavigationItemSelectedListener,OnItemClickListener {
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
        toolbar = findViewById(R.id.toolBar_home);
        setSupportActionBar(toolbar);
        loadCategories();
        drawerLayout = findViewById(R.id.activity_main);
        navigateToSearch();
        setMenuDrawer();
        setBottomNavigation();
    }

    private void BarCodeScanner(){
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        scanBtn.setOnClickListener(this);
    }

    private void setBottomNavigation()
    {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private void setMenuDrawer()
    {
        final ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
    }

    private void navigateToSearch()
    {
        searchView=(SearchView) findViewById(R.id.txtSearch);
        searchView.setIconifiedByDefault(false);
        searchView.setQueryHint("Search minimart products");
        searchView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                openSearchActivity();
            }
        });
    }

    private void loadCategories()
    {
        listCategoryList = new ArrayList<>();
        listCategoryList.add(new Category("Biscuit","Biscuit","Biscuit",R.drawable.category_biscuits,1));
        listCategoryList.add(new Category("Drinks","Drinks","Drinks",R.drawable.category_drinks,2));
        listCategoryList.add(new Category("Grocery & Staples","Grocery & Staples","Grocery & Staples",R.drawable.category_grocerystaples,3));
        listCategoryList.add(new Category("Oats","Oats","Oats",R.drawable.category_oats,4));
        listCategoryList.add(new Category("Oil","Oil","Oil",R.drawable.category_oil,5));
        listCategoryList.add(new Category("Beverages","Beverages","Beverages",R.drawable.category_teacoffe,6));
        RecyclerView recyclerView = findViewById(R.id.recycler_category);
        recyclerView.setHasFixedSize(true);
        CategoryAdapter categoryAdapter = new CategoryAdapter(listCategoryList);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Intent intent;
                switch (listCategoryList.get(position).getCategory())
                {
                    case "Biscuit":
                        intent= new Intent(getBaseContext(), ProductMilkAndDiariesActivity.class);
                        startActivity(intent);
                        break;
                }
            }

            @Override
            public void onLongClicked(int position) {

            }
        });
    }

    private void openSearchActivity(){
        Intent intent= new Intent(this, SearchActivity.class);
        startActivity(intent);
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
//            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
//            scanIntegrator.initiateScan();
            Intent intent = new Intent(this, ScheduleActivity.class);
            startActivity(intent);
        }
        Intent intent;
        switch(view.getId())
        {
            case R.id.txtSearch:
                intent= new Intent(this, ScheduleActivity.class);
                startActivity(intent);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Intent intent;
        switch (menuItem.getItemId()){
            case R.id.navigation_schedule:
                intent= new Intent(this, ScheduleActivity.class);
                startActivity(intent);
                return true;
            case R.id.navigation_basket:
                 intent = new Intent(this, BasketActivity.class);
                startActivity(intent);
                return true;
            case R.id.navigation_categories:
                 intent = new Intent(this, WalletActivity.class);
                startActivity(intent);
                return true;
            case R.id.navigation_home:
                 intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    public void OnItemClick(int position) {
        Toast.makeText(this,"Item Pressed = ",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLongClicked(int position) {
        Toast.makeText(this,"Item Pressed = ",Toast.LENGTH_SHORT).show();

    }
}
