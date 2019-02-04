package com.hdw.android.dashboard.manager.http;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.hdw.android.dashboard.manager.Contextor;
import com.hdw.android.dashboard.util.SharedPrefManager;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


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

        mContext = com.hdw.android.dashboard.manager.Contextor .getInstance().getContext();

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });
        Gson gson = builder.create();

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();

                Request request = original.newBuilder()
                        .header("Authorization",SharedPrefManager.getInstance(Contextor.getInstance().getContext()).getToken())
                        .header("Content-Type","application/json")
                        .method(original.method(),original.body())
                        .build();


                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://103.13.31.63:8555/restaurant/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        service = retrofit.create(ApiService.class);

    }

    public ApiService getService(){
        return service;
    }

}
