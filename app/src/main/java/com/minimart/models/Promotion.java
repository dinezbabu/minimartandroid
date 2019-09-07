package com.minimart.models;

public class Promotion {
    private String promotionId;
    private String promotionName;
    private String promotionCode;
    private float promotionPercentage;

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId;
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName;
    }

    public String getPromotionCode() {
        return promotionCode;
    }

    public void setPromotionCode(String promotionCode) {
        this.promotionCode = promotionCode;
    }

    public float getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(float promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }
}
