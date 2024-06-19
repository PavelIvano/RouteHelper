package com.example.pavel2.Thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pavel2.R;

public class ThreadActivity2 extends AppCompatActivity {
    TextView tv;
    String s = "";

    public Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            Toast.makeText(getApplicationContext(),
                     "With handler", Toast.LENGTH_SHORT).show();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread2);
        tv = findViewById(R.id.textView7);
        MyFirstThread t = new MyFirstThread();
        t.start();
        Thread t2 = new Thread(() -> {
            runOnUiThread(() -> {

                Toast.makeText(this, "anonymus", Toast.LENGTH_SHORT).show();
            });
        });
        t2.start();
        ThreadWithHandler t3 = new ThreadWithHandler(handler);
        t3.start();
    }

    class MyFirstThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    s = s + "2";
                    ThreadActivity2.this.runOnUiThread(() -> {
                        tv.setText(s);

                    });
 //                   tv.append("2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}