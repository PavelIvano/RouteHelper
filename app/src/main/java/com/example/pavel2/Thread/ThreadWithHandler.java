package com.example.pavel2.Thread;

import android.os.Handler;

public class ThreadWithHandler extends Thread{

    private final Handler handler;

    public ThreadWithHandler(Handler handler) {
        this.handler = handler;
    }

    public void run () {
        try {
            Thread.sleep(5000);
            handler.sendEmptyMessage(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        };
    }
}
