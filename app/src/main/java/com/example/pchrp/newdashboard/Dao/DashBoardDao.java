package com.example.pchrp.newdashboard.Dao;

import com.example.pchrp.newdashboard.Dao.bank.BankItemDao;
import com.example.pchrp.newdashboard.Dao.object.ObjectItemDao;

import java.util.List;

public class DashBoardDao {

    private Long statusCode;
    private String message;
    private List<ObjectItemDao> object;

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

    public List<ObjectItemDao> getObject() {
        return object;
    }

    public void setObject(List<ObjectItemDao> object) {
        this.object = object;
    }
}
