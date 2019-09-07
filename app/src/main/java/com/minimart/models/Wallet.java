package com.minimart.models;

import java.util.StringTokenizer;

public class Wallet {
    private String walletId;
    private String walletTransactionNumber;
    private float walletTransactionAmount;
    private float walletAvailableBalance;

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public String getWalletTransactionNumber() {
        return walletTransactionNumber;
    }

    public void setWalletTransactionNumber(String walletTransactionNumber) {
        this.walletTransactionNumber = walletTransactionNumber;
    }

    public float getWalletTransactionAmount() {
        return walletTransactionAmount;
    }

    public void setWalletTransactionAmount(float walletTransactionAmount) {
        this.walletTransactionAmount = walletTransactionAmount;
    }

    public float getWalletAvailableBalance() {
        return walletAvailableBalance;
    }

    public void setWalletAvailableBalance(float walletAvailableBalance) {
        this.walletAvailableBalance = walletAvailableBalance;
    }
}
