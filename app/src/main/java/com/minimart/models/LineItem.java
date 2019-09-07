package com.minimart.models;

public class LineItem {
    private String productName;
    private float productPrice;
    private int productQty;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public LineItem(String productName, float productPrice, int productQty) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQty = productQty;
    }

}
