package com.example.pchrp.newdashboard.Dao.product;

import java.util.List;

public class DrinkProductItemCollectionDao {

    private Object product;
    private Long withdrawUse;
    private Long purchaseAmount;
    private Long entertainAmount;
    private Long totalAll;

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public Long getWithdrawUse() {
        return withdrawUse;
    }

    public void setWithdrawUse(Long withdrawUse) {
        this.withdrawUse = withdrawUse;
    }

    public Long getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(Long purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Long getEntertainAmount() {
        return entertainAmount;
    }

    public void setEntertainAmount(Long entertainAmount) {
        this.entertainAmount = entertainAmount;
    }

    public Long getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(Long totalAll) {
        this.totalAll = totalAll;
    }
}
