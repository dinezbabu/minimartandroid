package com.minimart.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.minimart.groceries.R;
import com.minimart.interfaces.OnItemClickListener;
import com.minimart.models.Category;

import java.lang.ref.WeakReference;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    public OnItemClickListener itemClickListener;
    public static List<Category> categoryList;

    public CategoryAdapter(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }
    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
     View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categories_layout,viewGroup,false);
    return new CategoryViewHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.txtCategory.setText(categoryList.get(i).getTitle());
        categoryViewHolder.imgViewCategory.setImageResource(categoryList.get(i).getThumbnail());
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        TextView txtCategory;
        ImageView imgViewCategory;

        public CategoryViewHolder(@NonNull final View itemView,final OnItemClickListener listener) {
            super(itemView);
            txtCategory = itemView.findViewById(R.id.txtcategory_grocery);
            imgViewCategory = itemView.findViewById(R.id.imgcategory_grocery);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            Toast.makeText(v.getContext(), "Item Pressed = " + String.valueOf(getAdapterPosition()), Toast.LENGTH_SHORT).show();
                            listener.OnItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
