package com.minimart.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.minimart.groceries.R;
import com.minimart.interfaces.OnItemClickListener;
import com.minimart.models.LineItem;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.LineItemViewHolder> {
    private ArrayList<LineItem> mLineItemList;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {mListener=listener;}

    public OrderAdapter(ArrayList<LineItem> lineItemList){mLineItemList=lineItemList;}

    @NonNull
    @Override
    public LineItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull LineItemViewHolder lineItemViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class LineItemViewHolder extends RecyclerView.ViewHolder{
        private TextView mProductName;
        private EditText mProductQty;
        private TextView mProductPrice;

        public LineItemViewHolder(View itemView,final  OnItemClickListener listener){
            super(itemView);
            mProductName= itemView.findViewById(R.id.product_name);
            mProductPrice=itemView.findViewById(R.id.product_price);
            mProductQty=itemView.findViewById(R.id.product_qty);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(listener!=null){
                        int poistion = getAdapterPosition();
                        if(poistion!= RecyclerView.NO_POSITION){
                            listener.OnItemClick(poistion);
                        }
                    }
                }
            });
        }
    }
}
