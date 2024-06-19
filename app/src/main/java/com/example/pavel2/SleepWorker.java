package com.example.pavel2;

import android.content.Context;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SleepWorker extends Worker {

    public SleepWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        Data d = getInputData();
        try {
            Thread.sleep(1000 * d.getInt("time",10));
            System.out.println("Async process finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Data data = new Data.Builder()
                .putDouble("result", Math.random())
                .build();
        return Result.success(data);
    }
}
