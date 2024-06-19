package com.example.pavel2.module5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pavel2.R;
import com.example.pavel2.RetrofitHelper;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {
    ListView postsLV;

    ArrayList<Post> posts = new ArrayList<>();
    ArrayAdapter<Post> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        postsLV = findViewById(R.id.postsLV);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, posts);
        postsLV.setAdapter(adapter);

        PostService s = RetrofitHelper.instance().create(PostService.class);
        Call<ArrayList<Post>> call = s.posts();
        s.getPostById(1,5);
        s.getPostById(55,52);

        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                posts.clear();
                ArrayList<Post> serverPosts = response.body();
                posts.addAll(serverPosts);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });
    }
}