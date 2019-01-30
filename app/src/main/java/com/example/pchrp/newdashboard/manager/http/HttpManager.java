package com.example.pchrp.newdashboard.manager.http;

import android.content.Context;

import com.example.pchrp.newdashboard.util.UnsafeOkHttpClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.lang.reflect.Type;
import java.util.Date;

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

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.13.31.63:8555/restaurant/api/")
                //.baseUrl("http://192.168.1.66:8555/restaurant/api/restaurant/v1/bpm/dashboard/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ApiService.class);

    }

    public ApiService getService(){
        return service;
    }

}
