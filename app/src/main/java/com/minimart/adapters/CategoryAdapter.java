package com.minimart.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.minimart.groceries.R;
import com.minimart.models.Category;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private Context categoryContext;
    private List<Category> categoryList;

    public CategoryAdapter(Context categoryContext, List<Category> categoryList) {
        this.categoryContext = categoryContext;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        LayoutInflater layoutInflater= LayoutInflater.from(categoryContext);
        view = layoutInflater.inflate(R.layout.categories_layout,viewGroup,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.txtCategory.setText(categoryList.get(i).getTitle());
        categoryViewHolder.imgViewCategory.setImageResource(categoryList.get(i).getThumbnail());
        categoryViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView txtCategory;
        ImageView imgViewCategory;
        CardView cardView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            txtCategory= itemView.findViewById(R.id.txtcategory_grocery);
            imgViewCategory=itemView.findViewById(R.id.imgcategory_grocery);
            cardView = itemView.findViewById(R.id.cardview_category);
        }
    }
}
