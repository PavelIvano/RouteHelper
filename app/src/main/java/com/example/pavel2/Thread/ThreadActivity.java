package com.example.pavel2.Thread;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.pavel2.R;
import com.example.pavel2.SleepWorker;

public class ThreadActivity extends AppCompatActivity {
    Button sync, async;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        sync = findViewById(R.id.button);
        async = findViewById(R.id.button2);
        sync.setOnClickListener((v) -> {
            try {
                Thread.sleep(10000);
                Toast.makeText(this, "Sync process finished", Toast.LENGTH_SHORT).show();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        async.setOnClickListener((v) -> {
            Data data = new Data.Builder()
                    .putInt("time",6)
                    .build();
            OneTimeWorkRequest work = new OneTimeWorkRequest.Builder(SleepWorker.class)
                    .setInputData(data)
                    .build();

            WorkManager.getInstance(getApplicationContext()).enqueue(work);
            WorkManager.getInstance(getApplicationContext())
                    .getWorkInfoByIdLiveData(work.getId())
                    .observe(ThreadActivity.this,(w) -> {
                        if (w != null) {
                            Data result = w.getOutputData();
                            Double random = result.getDouble("result", 0.0);
                            Toast.makeText(this,"Generated" + random, Toast.LENGTH_SHORT).show();
                        }
                    });

        });
    }
}