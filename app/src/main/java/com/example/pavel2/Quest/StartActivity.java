package com.example.pavel2.Quest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pavel2.R;

public class StartActivity extends AppCompatActivity {
    EditText nameET;
    Button startBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        nameET = this.findViewById(R.id.nameTv);
        startBTN = this.findViewById(R.id.startBTN);
        startBTN.setOnClickListener((v) -> {
            startActivity(new Intent(this, SituationActivity.class));
        });

       Intent i = new Intent(StartActivity.this,SituationActivity.class);
        i.putExtra("username",nameET.getText().toString());
        startActivity(i);
    }
}