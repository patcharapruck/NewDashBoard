package com.hdw.android.dashboard.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_LOGIN = "mydate";
    private static final String KEY_USER = "user";
    private static final String KEY_PASS= "pass";
    private static final String KEY_TOKEN = "token";


    SharedPrefManager(Context context) {
        mCtx = context;

    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }

    public boolean saveLogin(String user,String pass,String token){

        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(KEY_USER,user);
        editor.putString(KEY_PASS,pass);
        editor.putString(KEY_TOKEN,token);

        editor.apply();

        return true;
    }

    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER,"");
    }
    public String getPassword(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASS,"");
    }
    public String getToken(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_LOGIN, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_TOKEN,"");
    }

}
