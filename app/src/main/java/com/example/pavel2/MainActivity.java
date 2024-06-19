package com.example.pavel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText loginET;
    EditText pwdET = null;
    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        loginET = this.findViewById(R.id.loginVal);
//        pwdET = this.findViewById(R.id.pwdET);
//        loginBtn = this.findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String login = loginET.getText().toString();
                String pwd = pwdET.getText().toString();
                if (login.equals("hello") && pwd.equals("world")) {
                    Toast.makeText(MainActivity.this, "you hack pentagon", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getBaseContext(), NewsActivity.class);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "не в этот раз)))", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}