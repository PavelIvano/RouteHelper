package com.example.pavel2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GetActivity extends AppCompatActivity {
    TextView messageTV;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get);
        messageTV = findViewById(R.id.messageTV);
        Intent intent = getIntent();
        messageTV.setText(intent.getStringExtra("message"));
    }
}