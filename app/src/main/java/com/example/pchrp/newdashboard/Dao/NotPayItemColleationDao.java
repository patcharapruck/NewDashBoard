package com.example.pchrp.newdashboard.Dao;

import com.example.pchrp.newdashboard.Dao.pagination.PaginationNotPayDao;
import com.example.pchrp.newdashboard.Dao.pagination.PaginationPayDao;
import com.example.pchrp.newdashboard.Dao.payment.PayItemDao;

import java.util.List;

public class NotPayItemColleationDao {

    private Long statusCode;
    private String message;
    private PaginationNotPayDao pagination;
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

    public PaginationNotPayDao getPagination() {
        return pagination;
    }

    public void setPagination(PaginationNotPayDao pagination) {
        this.pagination = pagination;
    }

    public List<PayItemDao> getObject() {
        return object;
    }

    public void setObject(List<PayItemDao> object) {
        this.object = object;
    }
}


