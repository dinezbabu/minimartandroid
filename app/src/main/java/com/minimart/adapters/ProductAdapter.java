package com.minimart.adapters;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.minimart.groceries.R;
import com.minimart.interfaces.OnItemClickListener;
import com.minimart.models.Product;
import com.minimart.models.ProductVariant;

import java.util.List;

public class ProductAdapter extends BaseAdapter {

    public static List<Product> productList;
    public static List<ProductVariant> productVariantList;

    public ProductAdapter(List<Product> productList,List<ProductVariant> productVariantList){
        this.productList=productList;
        this.productVariantList= productVariantList;
    }
    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int position) {
        System.out.println("getItem" + position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        System.out.println("getItemId"+position);
        return 0;
    }

    private void strikeThroughText(TextView price){
        price.setPaintFlags(price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_layout,parent,false);
        TextView txtProductName = convertView.findViewById(R.id.product_name);
        ImageView imgProductThumbNail = convertView.findViewById(R.id.product_thumbnail);
        TextView txtProductWeighed = convertView.findViewById(R.id.product_weighted);
        TextView txtProductMRPrice = convertView.findViewById(R.id.product_MRP);
        TextView txtProductMMPrice = convertView.findViewById(R.id.product_MM);
        Spinner dropDownProductVariant = convertView.findViewById(R.id.productvaraintspinner);

        if(!txtProductMMPrice.getText().equals(txtProductMRPrice.getText()))
            strikeThroughText(txtProductMRPrice);

        txtProductName.setText(productList.get(position).getProductName());
        imgProductThumbNail.setImageResource(productList.get(position).getProductThumbNail());
        txtProductMMPrice.setText("₹"+ String.valueOf(productList.get(position).getProductMMPrice()));
        txtProductMRPrice.setText("₹"+ String.valueOf(productList.get(position).getProductMRPrice()));
        txtProductWeighed.setText(productList.get(position).getProductWeighed());

        //Load Dropdown
        if(productVariantList!=null) {
            ArrayAdapter<ProductVariant> productVariantArrayAdapter = new ArrayAdapter<>(convertView.getContext(), android.R.layout.simple_spinner_item, productVariantList);
            productVariantArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            dropDownProductVariant.setAdapter(productVariantArrayAdapter);
//            TextView txtProductVariantWeighted = convertView.findViewById(R.id.productVariantWeighted);
//            TextView txtProductVariantMRPrice = convertView.findViewById(R.id.productVariantMRprice);
//            TextView txtProductVariantMMPrice = convertView.findViewById(R.id.productVariantMMprice);
//
//            txtProductVariantWeighted.setText(productVariantList.get(position).getProductVariantWeighted());
//            txtProductVariantMRPrice.setText(String.valueOf(productVariantList.get(position).getProductVariantMRPrice()));
//            txtProductVariantMMPrice.setText(String.valueOf(productVariantList.get(position).getProductVariantWeighted()));


        }

        return convertView;
    }
}
