package com.example.pchrp.newdashboard.Dao.product;

import java.util.List;

public class DrinkProductItemCollectionDao {

    private List<DrinkProductItemDao> product;
    private int withdrawUse;
    private int purchaseAmount;
    private int entertainAmount;
    private int totalAll;

    public List<DrinkProductItemDao> getProduct() {
        return product;
    }

    public void setProduct(List<DrinkProductItemDao> product) {
        this.product = product;
    }

    public int getWithdrawUse() {
        return withdrawUse;
    }

    public void setWithdrawUse(int withdrawUse) {
        this.withdrawUse = withdrawUse;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public int getEntertainAmount() {
        return entertainAmount;
    }

    public void setEntertainAmount(int entertainAmount) {
        this.entertainAmount = entertainAmount;
    }

    public int getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(int totalAll) {
        this.totalAll = totalAll;
    }
}
