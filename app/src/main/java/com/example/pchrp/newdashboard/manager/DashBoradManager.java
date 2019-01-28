package com.example.pchrp.newdashboard.manager;

import android.content.Context;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.objectdao.ObjectItemDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DashBoradManager {

    private static DashBoradManager instance;
    //private DashBoardDao Dao;
    private DashBoardDao Dao;
    public static DashBoradManager getInstance() {
        if (instance == null)
            instance = new DashBoradManager();
        return instance;
    }

//    public DashBoardDao getDao() {
//        return Dao;
//    }
//
//    public void setDao(DashBoardDao dao) {
//        Dao = dao;
//    }


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
