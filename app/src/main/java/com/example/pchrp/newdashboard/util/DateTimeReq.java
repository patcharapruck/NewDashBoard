package com.example.pchrp.newdashboard.util;

import java.util.Date;

public class DateTimeReq {

    private Date date;
    private int dayofMonth;
    private int month;
    private int year;
    private String reqDate;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDayofMonth() {
        return dayofMonth;
    }

    public void setDayofMonth(int dayofMonth) {
        this.dayofMonth = dayofMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReqDate() {
        return reqDate;
    }

    public void setReqDate(String reqDate) {
        this.reqDate = reqDate;
    }
}
