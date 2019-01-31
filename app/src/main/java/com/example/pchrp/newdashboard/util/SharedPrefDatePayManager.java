package com.example.pchrp.newdashboard.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefDatePayManager {

    private static SharedPrefDatePayManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mydate";
    private static final String KEY_PATMENT = "pay";
    private static final String KEY_ALLPAY = "allpay";
    private static final String KEY_NOTPAY = "notpay";



    SharedPrefDatePayManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefDatePayManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefDatePayManager(context);
        }
        return mInstance;
    }

    public boolean savePay(Long pay){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(KEY_PATMENT,pay);
        editor.apply();

        return true;
    }

    public boolean saveNotPay(Long notpay){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(KEY_NOTPAY,notpay);
        editor.apply();

        return true;
    }



    public Long getPay(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(KEY_PATMENT,0);
    }
    public Long getNotPay(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getLong(KEY_NOTPAY,0);
    }



}
