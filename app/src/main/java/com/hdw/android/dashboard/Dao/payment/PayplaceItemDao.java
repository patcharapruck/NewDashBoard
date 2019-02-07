package com.hdw.android.dashboard.Dao.payment;

public class PayplaceItemDao {

    private String placeType;
    private String placeNameTh;
    private String placeNameEn;
    private String placeCode;

    public String getPlaceNameTh() {
        return placeNameTh;
    }

    public void setPlaceNameTh(String placeNameTh) {
        this.placeNameTh = placeNameTh;
    }

    public String getPlaceNameEn() {
        return placeNameEn;
    }

    public void setPlaceNameEn(String placeNameEn) {
        this.placeNameEn = placeNameEn;
    }

    public String getPlaceCode() {
        return placeCode;
    }

    public void setPlaceCode(String placeCode) {
        this.placeCode = placeCode;
    }

    public String getPlaceType() {
        return placeType;
    }

    public void setPlaceType(String placeType) {
        this.placeType = placeType;
    }
}
