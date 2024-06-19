package com.example.pavel2.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.impl.utils.ForceStopRunnable;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ListView;

import com.example.pavel2.ExcursionAdapter;
import com.example.pavel2.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Route;

public class ExcursionActivity extends AppCompatActivity {
    private ListView excLV;
    public static ArrayList<Excursion> excursions2;
    private ExcursionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion2);
        int position = getIntent().getIntExtra("position", -1);
        Excursion excursion = MainActivity.excursions.get(position);

        registerReceiver(receiver2, new IntentFilter(ExcService.CHANNEL));

        excursions2 = new ArrayList<Excursion>();
        adapter = new ExcursionAdapter(this,excursions2);
        excLV = (ListView) findViewById(R.id.excLV);
        excLV.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, ExcService.class);
        stopService(intent);
    }

    protected BroadcastReceiver receiver2 = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {

                String q2 = intent.getStringExtra(ExcService.INFO);
                JSONArray json = new JSONArray(q2);
                excursions2.clear();
                for (int i = 0; i < json.length(); i++) {
                    Excursion e = new Excursion();
                    JSONObject o = json.getJSONObject(i);
                    e.setId(o.getInt("id"));
                    e.setType(o.getString("type"));
                    e.setTitle(o.getString("title"));
                    e.setUrl(o.getString("url"));
                    e.setVisitors(o.getInt("visitors"));
                    excursions2.add(e);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter.notifyDataSetChanged();
        }
    };
}