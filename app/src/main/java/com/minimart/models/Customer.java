package com.minimart.models;

import java.util.Date;

public class Customer {
    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private String customerEmail;
    private boolean customerStatus;
    private Date customerJoinedDate;
    private boolean customerIsLoyalCustomer;
    private Wallet customerWallet;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public boolean isCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(boolean customerStatus) {
        this.customerStatus = customerStatus;
    }

    public Date getCustomerJoinedDate() {
        return customerJoinedDate;
    }

    public void setCustomerJoinedDate(Date customerJoinedDate) {
        this.customerJoinedDate = customerJoinedDate;
    }

    public boolean isCustomerIsLoyalCustomer() {
        return customerIsLoyalCustomer;
    }

    public void setCustomerIsLoyalCustomer(boolean customerIsLoyalCustomer) {
        this.customerIsLoyalCustomer = customerIsLoyalCustomer;
    }

    public Wallet getCustomerWallet() {
        return customerWallet;
    }

    public void setCustomerWallet(Wallet customerWallet) {
        this.customerWallet = customerWallet;
    }
}
