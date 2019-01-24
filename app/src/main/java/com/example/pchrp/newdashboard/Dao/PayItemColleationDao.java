package com.example.pchrp.newdashboard.Dao;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PayItemColleationDao {

    @SerializedName("success") private boolean success;
    @SerializedName("data") private List<PayItemDao> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<PayItemDao> getData() {
        return data;
    }

    public void setData(List<PayItemDao> data) {
        this.data = data;
    }
}


