package com.minimart.models;

import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;

public class Product {
    private String productName;
    private String productId;
    private String productBarCode;
    private String productDescription;
    private String productWeighed;
    private float productMMPrice;
    private float productMRPrice;
    private float productGST;
    private float prodcutCGST;
    private Promotion productPromotion;
    private String productHSNCode;
    private boolean productIsAvaialble;
    private Date productExpDate;
    private int productThumbNail;
    private List<ProductVariant> productVariantList;

    public Product(String productId,String productName,int productThumbNail,boolean productIsAvaialble, String productDescription,String productWeighed,float productMRPrice,float productMMPrice,List<ProductVariant> productVariantList)
    {
        this.productName =productName;
        this.productId = productId;
        this.productDescription = productDescription;
        this.productIsAvaialble = productIsAvaialble;
        this.productWeighed= productWeighed;
        this.productMRPrice= productMRPrice;
        this.productMMPrice=productMMPrice;
        this.productThumbNail=productThumbNail;
        this.productVariantList = productVariantList;
    }

    public List<ProductVariant> getProductVariantList() {
        return productVariantList;
    }

    public void setProductVariantList(List<ProductVariant> productVariantList) {
        this.productVariantList = productVariantList;
    }

    public int getProductThumbNail() {
        return productThumbNail;
    }

    public void setProductThumbNail(int productThumbNail) {
        this.productThumbNail = productThumbNail;
    }

    public String getProductWeighed() {
        return productWeighed;
    }

    public void setProductWeighed(String productWeighed) {
        this.productWeighed = productWeighed;
    }

    public Promotion getProductPromotion() {
        return productPromotion;
    }

    public void setProductPromotion(Promotion productPromotion) {
        this.productPromotion = productPromotion;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductBarCode() {
        return productBarCode;
    }

    public void setProductBarCode(String productBarCode) {
        this.productBarCode = productBarCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public float getProductMMPrice() {
        return productMMPrice;
    }

    public void setProductMMPrice(float productMMPrice) {
        this.productMMPrice = productMMPrice;
    }

    public float getProductMRPrice() {
        return productMRPrice;
    }

    public void setProductMRPrice(float productMRPrice) {
        this.productMRPrice = productMRPrice;
    }

    public float getProductGST() {
        return productGST;
    }

    public void setProductGST(float productGST) {
        this.productGST = productGST;
    }

    public float getProdcutCGST() {
        return prodcutCGST;
    }

    public void setProdcutCGST(float prodcutCGST) {
        this.prodcutCGST = prodcutCGST;
    }

    public String getProductHSNCode() {
        return productHSNCode;
    }

    public void setProductHSNCode(String productHSNCode) {
        this.productHSNCode = productHSNCode;
    }

    public boolean isProductIsAvaialble() {
        return productIsAvaialble;
    }

    public void setProductIsAvaialble(boolean productIsAvaialble) {
        this.productIsAvaialble = productIsAvaialble;
    }

    public Date getProductExpDate() {
        return productExpDate;
    }

    public void setProductExpDate(Date productExpDate) {
        this.productExpDate = productExpDate;
    }
}
