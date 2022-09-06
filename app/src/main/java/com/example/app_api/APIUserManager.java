package com.example.app_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIUserManager {
    String SERVER_URL = "http://localhost:8080/api/User/";

    @GET("data.json")
    Call<User> getItemData();

    @GET("datas.json")
    Call<List<User>> getListData();

}
