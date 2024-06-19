package com.example.pavel2.retrofit;

import com.example.pavel2.module5.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UserService {
    @FormUrlEncoded
    @POST("/login")
    public Call<User> login(@Field(value = "email") String email,
                            @Field(value = "pwd") String pwd);

}
