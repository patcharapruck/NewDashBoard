package com.hdw.android.dashboard.Dao.product;

public class ProductSortDao {
    private String[] nameProductSort;
    private Long[] totalAllProductSort;
    private Long[] entertainProductSort;
    private Long[] purchaseProductSort;
    private Long[] withdrawProductSort;

    public String[] getNameProductSort() {
        return nameProductSort;
    }

    public void setNameProductSort(String[] nameProductSort) {
        this.nameProductSort = nameProductSort;
    }

    public Long[] getTotalAllProductSort() {
        return totalAllProductSort;
    }

    public void setTotalAllProductSort(Long[] totalAllProductSort) {
        this.totalAllProductSort = totalAllProductSort;
    }

    public Long[] getEntertainProductSort() {
        return entertainProductSort;
    }

    public void setEntertainProductSort(Long[] entertainProductSort) {
        this.entertainProductSort = entertainProductSort;
    }

    public Long[] getPurchaseProductSort() {
        return purchaseProductSort;
    }

    public void setPurchaseProductSort(Long[] purchaseProductSort) {
        this.purchaseProductSort = purchaseProductSort;
    }

    public Long[] getWithdrawProductSort() {
        return withdrawProductSort;
    }

    public void setWithdrawProductSort(Long[] withdrawProductSort) {
        this.withdrawProductSort = withdrawProductSort;
    }
}
