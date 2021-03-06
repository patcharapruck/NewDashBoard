package com.hdw.android.dashboard.manager;

import android.content.Context;

import com.hdw.android.dashboard.Dao.PayItemColleationDao;


public class PayManager {

    private static PayManager instance;
    private PayItemColleationDao payItemColleationDao;
    public static PayManager getInstance() {
        if (instance == null)
            instance = new PayManager();
        return instance;
    }

    public PayItemColleationDao getPayItemColleationDao() {
        return payItemColleationDao;
    }

    public void setPayItemColleationDao(PayItemColleationDao payItemColleationDao) {
        this.payItemColleationDao = payItemColleationDao;
    }

    private Context mContext;

    private PayManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
