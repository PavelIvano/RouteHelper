package com.example.pavel2.weather;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ExcService extends Service {


    public static final String CHANNEL = "ExcService";
    public static final String INFO = "INFO";
    private Handler h2;


    @Override
    public void onCreate() {

        h2 = new Handler(Looper.getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                Intent i = new Intent(CHANNEL);
                i.putExtra(INFO, msg.obj.toString());
                sendBroadcast(i);
            }
        };
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String t = intent.getStringExtra("title");
        Thread route = new Thread(new HTTPRequest2(h2,t));
        route.start();
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
