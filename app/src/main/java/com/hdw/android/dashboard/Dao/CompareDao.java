package com.hdw.android.dashboard.Dao;

import com.hdw.android.dashboard.Dao.objectdao.ObjectListItemDao;

import java.util.List;

public class CompareDao {
    private Long statusCode;
    private String message;
    private Object pagination;
    private List<ObjectListItemDao> object;


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

    public Object getPagination() {
        return pagination;
    }

    public void setPagination(Object pagination) {
        this.pagination = pagination;
    }

    public List<ObjectListItemDao> getObject() {
        return object;
    }

    public void setObject(List<ObjectListItemDao> object) {
        this.object = object;
    }
}
