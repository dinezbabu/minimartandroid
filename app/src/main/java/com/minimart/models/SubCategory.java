package com.minimart.models;

import java.util.List;

public class SubCategory {
    private String subcategoryId;
    private String subcategoryName;
    private List<Product> subcategoryProductList;

    public String getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(String subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public List<Product> getSubcategoryProducts() {
        return subcategoryProductList;
    }

    public void setSubcategoryProducts(List<Product> subcategoryProducts) {
        this.subcategoryProductList = subcategoryProducts;
    }
}
