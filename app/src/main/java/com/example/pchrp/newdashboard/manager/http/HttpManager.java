package com.example.pchrp.newdashboard.manager.http;

import android.content.Context;

import com.example.pchrp.newdashboard.util.UnsafeOkHttpClient;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.pchrp.newdashboard.util.UnsafeOkHttpClient.getUnsafeOkHttpClient;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManager {

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private Context mContext;
    private ApiService service;
    private HttpManager() {

        mContext = com.example.pchrp.newdashboard.manager.Contextor .getInstance().getContext();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://nuuneoi.com/courses/500px/")
                .client(getUnsafeOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);

    }

    public ApiService getService(){
        return service;
    }

}
