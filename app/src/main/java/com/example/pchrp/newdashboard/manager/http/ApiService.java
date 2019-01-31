package com.example.pchrp.newdashboard.manager.http;

import com.example.pchrp.newdashboard.Dao.CompareDao;
import com.example.pchrp.newdashboard.Dao.DashBoardDao;
import com.example.pchrp.newdashboard.Dao.NotPayItemColleationDao;
import com.example.pchrp.newdashboard.Dao.PayItemColleationDao;

import org.json.JSONStringer;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {


    @Headers({"Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNzdBMEY3ODU0RDc4QzZFNjExRjE3RjY2OEVCNEM2NUEiLCJleHAiOjE1NDkxMTc5ODMsImlhdCI6MTU0ODUxMzE4M30.CU4OB8KSM1k9FSWMxy3HjUGc9auNWqLgSDhV7I3-HmpJ5Ziu1UJuK_ZfzKhSeyjoQPr-GWrJBW9gSiFdW7mm_Q",
    "Content-Type:application/json"})
    @POST("restaurant/v1/bpm/dashboard/summary")
    Call<DashBoardDao> loadAPI(@Body RequestBody json);

    @Headers({"Authorization:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNzdBMEY3ODU0RDc4QzZFNjExRjE3RjY2OEVCNEM2NUEiLCJleHAiOjE1NDkxMTc5ODMsImlhdCI6MTU0ODUxMzE4M30.CU4OB8KSM1k9FSWMxy3HjUGc9auNWqLgSDhV7I3-HmpJ5Ziu1UJuK_ZfzKhSeyjoQPr-GWrJBW9gSiFdW7mm_Q",
    "Content-Type:application/json"})
    @POST("restaurant/v1/salesshift/search")
    Call<CompareDao> loadAPIcompare(@Body RequestBody json);

    @Headers({"Authorization:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNzdBMEY3ODU0RDc4QzZFNjExRjE3RjY2OEVCNEM2NUEiLCJleHAiOjE1NDkxMTc5ODMsImlhdCI6MTU0ODUxMzE4M30.CU4OB8KSM1k9FSWMxy3HjUGc9auNWqLgSDhV7I3-HmpJ5Ziu1UJuK_ZfzKhSeyjoQPr-GWrJBW9gSiFdW7mm_Q",
            "Content-Type:application/json"})
    @POST("restaurant/v1/invoicedocument/search")
    Call<PayItemColleationDao> loadAPIPay(@Body RequestBody json);

    @Headers({"Authorization:eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI0MTg3X0hEV18xIiwiYXVkIjoiNzdBMEY3ODU0RDc4QzZFNjExRjE3RjY2OEVCNEM2NUEiLCJleHAiOjE1NDkxMTc5ODMsImlhdCI6MTU0ODUxMzE4M30.CU4OB8KSM1k9FSWMxy3HjUGc9auNWqLgSDhV7I3-HmpJ5Ziu1UJuK_ZfzKhSeyjoQPr-GWrJBW9gSiFdW7mm_Q",
            "Content-Type:application/json"})
    @POST("restaurant/v1/invoicedocument/search")
    Call<NotPayItemColleationDao> loadAPINotPay(@Body RequestBody json);



}
