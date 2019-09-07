package com.minimart.models;

public class ProductVariant {
    private String productVarinatId;
    private float productVariantMRPrice;
    private float productVariantMMPrice;
    private String productVariantWeighted;

    public ProductVariant(String productVarinatId,String productVariantWeighted,float productVariantMRPrice,float productVariantMMPrice)
    {
        this.productVarinatId=productVarinatId;
        this.productVariantWeighted = productVariantWeighted;
        this.productVariantMRPrice = productVariantMRPrice;
        this.productVariantMMPrice = productVariantMMPrice;
    }

    public String getProductVarinatId() {
        return productVarinatId;
    }

    public void setProductVarinatId(String productVarinatId) {
        this.productVarinatId = productVarinatId;
    }

    public float getProductVariantMRPrice() {
        return productVariantMRPrice;
    }

    public void setProductVariantMRPrice(float productVariantMRPrice) {
        this.productVariantMRPrice = productVariantMRPrice;
    }

    public float getProductVariantMMPrice() {
        return productVariantMMPrice;
    }

    public void setProductVariantMMPrice(float productVariantMMPrice) {
        this.productVariantMMPrice = productVariantMMPrice;
    }

    public String getProductVariantWeighted() {
        return productVariantWeighted;
    }

    public void setProductVariantWeighted(String productVariantWeighted) {
        this.productVariantWeighted = productVariantWeighted;
    }
}
