package com.hdw.android.dashboard.Dao;

import com.hdw.android.dashboard.Dao.objectdao.ObjectItemDao;

public class DashBoardDao {

    private Long statusCode;
    private String message;
    private ObjectItemDao object;

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

    public ObjectItemDao getObject() {
        return object;
    }

    public void setObject(ObjectItemDao object) {
        this.object = object;
    }
}
