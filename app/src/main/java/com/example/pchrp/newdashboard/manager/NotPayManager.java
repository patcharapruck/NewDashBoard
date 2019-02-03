package com.example.pchrp.newdashboard.manager;

import android.content.Context;

import com.example.pchrp.newdashboard.Dao.NotPayItemColleationDao;


public class NotPayManager {

    private static NotPayManager instance;
    private NotPayItemColleationDao notpayItemColleationDao;
    public static NotPayManager getInstance() {
        if (instance == null)
            instance = new NotPayManager();
        return instance;
    }

    public NotPayItemColleationDao getNotpayItemColleationDao() {
        return notpayItemColleationDao;
    }

    public void setNotpayItemColleationDao(NotPayItemColleationDao notpayItemColleationDao) {
        this.notpayItemColleationDao = notpayItemColleationDao;
    }

    private Context mContext;

    private NotPayManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
