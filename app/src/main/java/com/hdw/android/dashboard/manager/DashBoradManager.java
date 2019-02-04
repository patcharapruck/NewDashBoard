package com.hdw.android.dashboard.manager;

import android.content.Context;

import com.hdw.android.dashboard.Dao.DashBoardDao;

public class DashBoradManager {

    private static DashBoradManager instance;
    private DashBoardDao Dao;
    public static DashBoradManager getInstance() {
        if (instance == null)
            instance = new DashBoradManager();
        return instance;
    }



    public DashBoardDao getDao() {
        return Dao;
    }

    public void setDao(DashBoardDao dao) {
        Dao = dao;
    }

    private Context mContext;

    private DashBoradManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
