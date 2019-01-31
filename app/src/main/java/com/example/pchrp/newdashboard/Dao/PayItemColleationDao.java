package com.example.pchrp.newdashboard.Dao;

import com.example.pchrp.newdashboard.Dao.pagination.PaginationPayDao;
import com.example.pchrp.newdashboard.Dao.payment.PayItemDao;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PayItemColleationDao {

    private Long statusCode;
    private String message;
    private PaginationPayDao pagination;
    private List<PayItemDao> object;

    public Long getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Long statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PaginationPayDao getPagination() {
        return pagination;
    }

    public void setPagination(PaginationPayDao pagination) {
        this.pagination = pagination;
    }

    public List<PayItemDao> getObject() {
        return object;
    }

    public void setObject(List<PayItemDao> object) {
        this.object = object;
    }
}


