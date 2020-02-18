package com.ds.repository;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static RetrofitInstance instance;
    private RetrofitInstance(){}

    public static RetrofitInstance getInstance(){
        if (instance == null)
            instance = new RetrofitInstance();
        return instance;
    }

    Retrofit getRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
