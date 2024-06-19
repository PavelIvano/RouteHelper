package com.example.pavel2.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.pavel2.R;

public class CirclesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new CircleView(this));
    }
}