package com.example.pavel2.module5;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PostService {
    @GET("/post")
    public Call<ArrayList<Post>> posts();
    @GET("/post{id}/photo/{photo_id}")
    public Call<Post> getPostById(@Path("id") int id,
                                  @Path("photo_id") int photo);

}
