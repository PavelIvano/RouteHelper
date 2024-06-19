package com.example.pavel2.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavel2.Quest.StartActivity;
import com.example.pavel2.R;

public class LoginActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBTN = findViewById(R.id.loginBTN);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("user") && password.getText().toString().equals("1234")) {
                    Toast.makeText(LoginActivity.this, "Уcпешный вход", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), MainActivity.class);
                    i.putExtra("username", username.getText().toString());
                    startActivity(i);
                } else {
                    Toast.makeText(LoginActivity.this, "Неверный пароль или логин", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}