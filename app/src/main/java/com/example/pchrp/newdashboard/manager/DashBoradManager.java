package com.example.pchrp.newdashboard.manager;

import android.content.Context;

import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.object.ObjectItemDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class DashBoradManager {

    private static DashBoradManager instance;
    //private DashBoardDao Dao;
    private ObjectItemDao Dao;
    public static DashBoradManager getInstance() {
        if (instance == null)
            instance = new DashBoradManager();
        return instance;
    }

    public ObjectItemDao getDao() {
        return Dao;
    }

    public void setDao(ObjectItemDao dao) {
        Dao = dao;
    }

    private Context mContext;

    private DashBoradManager() {
        mContext = Contextor.getInstance().getContext();
    }

}
