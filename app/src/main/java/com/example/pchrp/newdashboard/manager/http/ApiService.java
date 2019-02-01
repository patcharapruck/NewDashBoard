package com.example.pchrp.newdashboard.manager.http;

import com.example.pchrp.newdashboard.Dao.CompareDao;
import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.LoginItemDao;
import com.example.pchrp.newdashboard.Dao.NotPayItemColleationDao;
import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;

import org.json.JSONStringer;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


    @POST("restaurant/v1/bpm/dashboard/summary")
    Call<DashBoardDao> loadAPI(@Body RequestBody json);

    @POST("restaurant/v1/salesshift/search")
    Call<CompareDao> loadAPIcompare(@Body RequestBody json);

    @POST("restaurant/v1/invoicedocument/search")
    Call<PayItemColleationDao> loadAPIPay(@Body RequestBody json);

    @POST("restaurant/v1/invoicedocument/search")
    Call<NotPayItemColleationDao> loadAPINotPay(@Body RequestBody json);

    @POST("restaurant/v1/login")
    Call<LoginItemDao> loadAPIToken(@Body RequestBody login);



}
