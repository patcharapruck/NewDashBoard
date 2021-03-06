package com.hdw.android.dashboard.manager.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpLoginManager {

    private static HttpLoginManager instance;

    public static HttpLoginManager getInstance() {
        if (instance == null)
            instance = new HttpLoginManager();
        return instance;
    }

    private Context mContext;
    private ApiService service;
    private HttpLoginManager() {

        mContext = com.hdw.android.dashboard.manager.Contextor .getInstance().getContext();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.13.31.63:8555/restaurant/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        service = retrofit.create(ApiService.class);

    }

    public ApiService getService(){
        return service;
    }

}
