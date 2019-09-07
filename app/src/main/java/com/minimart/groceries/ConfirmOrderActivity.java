package com.minimart.groceries;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.minimart.adapters.OrderAdapter;
import com.minimart.interfaces.OnItemClickListener;
import com.minimart.models.LineItem;

import java.util.ArrayList;

public class ConfirmOrderActivity extends AppCompatActivity {

    ArrayList<LineItem> mLineItemList;
    OrderAdapter mAdapter;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mlayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        Toolbar toolbar = findViewById(R.id.arrow_toolbar);
        setSupportActionBar(toolbar);
        final ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Confirm Order");
        createLineItem();
        buildRecyclerView();
        setButtons();
    }

    public void setButtons(){

    }

    public void insertItem(int position){
        mLineItemList.add(position,new LineItem(" Tea",45.0f,2));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem  (int position){
        mLineItemList.remove(position);
        mAdapter.notifyItemInserted(position);
    }

    public void changeItem(int position,String Text){
        mLineItemList.get(position).setProductPrice(34.0f);
        mLineItemList.get(position).setProductQty(4);
        mAdapter.notifyItemInserted(position);
    }

    public void createLineItem(){
        mLineItemList= new ArrayList<>();
        mLineItemList.add(new LineItem("Sugar 1kg",24.0f,2));
        mLineItemList.add(new LineItem("Dhal 1kg",14.0f,1));
        mLineItemList.add(new LineItem("Atta 1kg",39.0f,20));
        mLineItemList.add(new LineItem("Salt 1kg",9.0f,5));
        mLineItemList.add(new LineItem("Oil 1tr",78.0f,3));
    }

    public void buildRecyclerView()
    {
        mRecyclerView= findViewById(R.id.recycler_category);
        mRecyclerView.setHasFixedSize(true);
        mlayoutManager = new LinearLayoutManager(this);
        mAdapter=new OrderAdapter(mLineItemList);

        mRecyclerView.setLayoutManager(mlayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                changeItem(position,"Clicked");
            }

            @Override
            public void onLongClicked(int position) {

            }
        });
    }
}
