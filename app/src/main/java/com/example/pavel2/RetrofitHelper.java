package com.example.pavel2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    public static Retrofit instance() {
        Retrofit r = new Retrofit.Builder()
                .baseUrl("http://192.168.1.73:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return r;

    }
}
