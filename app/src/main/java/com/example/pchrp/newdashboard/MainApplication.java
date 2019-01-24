package com.example.pchrp.newdashboard;

import android.app.Application;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        com.example.pchrp.newdashboard.manager.Contextor.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
