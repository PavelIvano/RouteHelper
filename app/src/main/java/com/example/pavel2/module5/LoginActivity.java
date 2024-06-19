package com.example.pavel2.module5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavel2.MainActivity;
import com.example.pavel2.NewsActivity;
import com.example.pavel2.R;
import com.example.pavel2.RetrofitHelper;
import com.example.pavel2.retrofit.UserService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    EditText loginET;
    EditText pwdET = null;
    TextView labelTV;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginET = this.findViewById(R.id.loginET);
        pwdET = this.findViewById(R.id.pwdET);
        loginBtn = this.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this::login);
        labelTV = findViewById(R.id.labelTV);
    }
    public void login(View view) {
        String email = loginET.getText().toString();
        String pwd = pwdET.getText().toString();
        if (email.isEmpty() || pwd.isEmpty()) {
            Toast.makeText(this, "Empty data", Toast.LENGTH_SHORT).show();
            return;
        }

        UserService us = RetrofitHelper.instance().create(UserService.class);
        us.login(email, pwd).enqueue(new retrofit2.Callback<User>() {
            @Override
            public void onResponse(retrofit2.Call<User> call, retrofit2.Response<User> response) {
                if (!response.isSuccessful()) {
                    runOnUiThread(() -> {
                        Toast.makeText(LoginActivity.this, "Bad password", Toast.LENGTH_SHORT).show();
                    });
                } else {
                    User u = response.body();
                    System.out.println(u);
                    runOnUiThread(() -> {
                        labelTV.setText(u.toString());
                        labelTV.setTextColor(Color.BLACK);
                        pwdET.setVisibility(View.GONE);
                        loginET.setVisibility(View.GONE);
                        loginBtn.setVisibility(View.GONE);
                    });
                }
            }

            @Override
            public void onFailure(retrofit2.Call<User> call, Throwable t) {

                runOnUiThread(() -> {
                    Toast.makeText(LoginActivity.this, "Server connection error", Toast.LENGTH_SHORT).show();
                });
                t.printStackTrace();
            }
        });

    }
}