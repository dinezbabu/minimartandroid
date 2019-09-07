package com.minimart.fragments;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.minimart.adapters.ProductAdapter;
import com.minimart.groceries.R;
import com.minimart.models.Product;
import com.minimart.models.ProductVariant;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MilkFragment extends Fragment {

    List<Product> listProductList;
    List<ProductVariant> listProductVariantList;

    public MilkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_milk, container, false);
        loadDropDown(view); //Need to check
        loadProducts(view);
        return view;
    }

    private void  loadDropDown(View view){
        listProductVariantList = new ArrayList<>();
        listProductVariantList.add(new ProductVariant("20001","250ml",75,72));
        listProductVariantList.add(new ProductVariant("20002","500ml",150,140));
        listProductVariantList.add(new ProductVariant("20003","1ltr",300,275));
//        Spinner productVariantSpinner = (Spinner) view.findViewById(R.id.productvaraintspinner);
//        ArrayAdapter<ProductVariant> productVariantArrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_spinner_item,listProductVariantList);
//        productVariantArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        productVariantSpinner.setAdapter(productVariantArrayAdapter);
//
//        productVariantSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(parent.getContext(),"Selected : "+item,Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }

    private void loadProducts(View view)
    {
        listProductList = new ArrayList<>();
        listProductList.add(new Product("10001","Milk - Nandhini Blue",R.drawable.nandhini_blue,true,"","500ml",23,22,listProductVariantList));
        listProductList.add(new Product("10002","Milk - Nandhini Orange",R.drawable.nandhini_orange,true,"","500ml",22,22,listProductVariantList));
        listProductList.add(new Product("10003","Milk - Nandhini Green",R.drawable.nandhini_green,true,"","500ml",20,19,listProductVariantList));
        listProductList.add(new Product("10004","Milk - Nandhini Blue",R.drawable.nandhini_blue,true,"","500ml",23,22,listProductVariantList));
        listProductList.add(new Product("10005","Milk - Nandhini Blue",R.drawable.nandhini_orange,true,"","500ml",22,21,listProductVariantList));
        listProductList.add(new Product("10006","Milk - Nandhini Blue",R.drawable.nandhini_green,true,"","500ml",20,19,listProductVariantList));
        ListView listViewProduct = view.findViewById(R.id.productListView);
        ProductAdapter productAdapter = new ProductAdapter(listProductList,listProductVariantList);
        listViewProduct.setAdapter(productAdapter);
    }
}
