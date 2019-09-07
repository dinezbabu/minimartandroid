package com.minimart.models;

import java.util.List;

public class Category {
    private String title;
    private String category;
    private String description;
    private int thumbnail;
    private int id;
    private List<SubCategory> categorySubCategoryList;

    public List<SubCategory> getCategorySubCategoryList() {
        return categorySubCategoryList;
    }

    public void setCategorySubCategoryList(List<SubCategory> categorySubCategoryList) {
        this.categorySubCategoryList = categorySubCategoryList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Category(String title, String category, String description, int thumbnail, int id) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;
        this.id=id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
