package com.example.pchrp.newdashboard.manager;

import android.content.Context;

import com.example.pchrp.newdashboard.Dao.CompareDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CompareManager {

    private static CompareManager instance;
    CompareDao compareDao;
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
