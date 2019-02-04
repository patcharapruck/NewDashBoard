package com.hdw.android.dashboard;

import android.app.Application;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        com.hdw.android.dashboard.manager.Contextor.getInstance().init(getApplicationContext());

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
