package com.example.pchrp.newdashboard.manager.http;

import android.content.Context;

import com.example.pchrp.newdashboard.Dao.NotPayItemColleationDao;
import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;
import com.example.pchrp.newdashboard.manager.Contextor;


public class NotPayManager {

    private static NotPayManager instance;
    private NotPayItemColleationDao notpayItemColleationDao;
    public static NotPayManager getInstance() {
        if (instance == null)
            instance = new NotPayManager();
        return instance;
    }

    public NotPayItemColleationDao getNotPayItemColleationDao() {
        return notpayItemColleationDao;
    }

    public void setPayItemColleationDao(NotPayItemColleationDao notpayItemColleationDao) {
        this.notpayItemColleationDao = notpayItemColleationDao;
    }

    private Context mContext;

    private NotPayManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
