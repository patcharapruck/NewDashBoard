package com.hdw.android.dashboard.manager;

import android.content.Context;

import com.hdw.android.dashboard.Dao.CompareDao;


public class CompareManager {

    private static CompareManager instance;
    private CompareDao compareDao;
    public static CompareManager getInstance() {
        if (instance == null)
            instance = new CompareManager();
        return instance;
    }

    private Context mContext;

    public CompareDao getCompareDao() {
        return compareDao;
    }

    public void setCompareDao(CompareDao compareDao) {
        this.compareDao = compareDao;
    }

    private CompareManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
