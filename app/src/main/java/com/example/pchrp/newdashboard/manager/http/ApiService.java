package com.example.pchrp.newdashboard.manager.http;

import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("list")
    Call<PayItemColleationDao> loadlist();

}
