package com.hdw.android.dashboard.Dao;

import com.hdw.android.dashboard.Dao.notpayment.NotPayItemDao;
import com.hdw.android.dashboard.Dao.pagination.PaginationNotPayDao;

import java.util.List;

public class NotPayItemColleationDao {

    private Long statusCode;
    private String message;
    private PaginationNotPayDao pagination;
    private List<NotPayItemDao> object;

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

    public List<NotPayItemDao> getObject() {
        return object;
    }

    public void setObject(List<NotPayItemDao> object) {
        this.object = object;
    }
}


