package com.example.app_api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserAPI {
    String SERVER_URL = "http://192.168.1.28:8080/";

    @GET("data.json")
    Call<User> getItemData();

    @GET("api/user")
    Call<List<User>> getlistData();
}
