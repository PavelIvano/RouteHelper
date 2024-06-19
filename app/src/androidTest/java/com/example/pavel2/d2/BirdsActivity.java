package com.example.pavel2.d2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BirdsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(this));
    }
}