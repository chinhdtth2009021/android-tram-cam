package com.example.app_api;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private User[] users;
    private ArrayAdapter<User> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getListDataUser();
    }
    private void getListDataUser(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(UserAPI.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        UserAPI service = retrofit.create(UserAPI.class);
        service.getlistData().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> list = response.body();
                Log.d("User Size",String.valueOf(list.size()));
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.d("MainActivity","onFailure"+ t);
            }
        });
    }
}