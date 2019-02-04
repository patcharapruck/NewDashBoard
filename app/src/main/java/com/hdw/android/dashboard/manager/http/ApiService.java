package com.hdw.android.dashboard.manager.http;

import com.hdw.android.dashboard.Dao.CompareDao;
import com.hdw.android.dashboard.Dao.DashBoardDao;
import com.hdw.android.dashboard.Dao.LoginItemDao;
import com.hdw.android.dashboard.Dao.NotPayItemColleationDao;
import com.hdw.android.dashboard.Dao.PayItemColleationDao;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
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
