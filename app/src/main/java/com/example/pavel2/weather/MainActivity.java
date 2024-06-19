package com.example.pavel2.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.pavel2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView excList;
    public static ArrayList<Excursion> excursions;
    private ExcursionAdapter adapter;
    private EditText searchPT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchPT = findViewById(R.id.searchPT);
        excursions = new ArrayList<Excursion>();
        searchPT.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                Intent intent = new Intent(getBaseContext(), GisService.class);
                intent.putExtra("city",s.toString());
                startService(intent);
                // TODO Auto-generated method stub
            }
        });

        registerReceiver(receiver, new IntentFilter(GisService.CHANNEL));

        adapter = new ExcursionAdapter(this, excursions);
        excList = (ListView) findViewById(R.id.excList);
        excList.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Intent intent = new Intent(this, GisService.class);
        stopService(intent);
    }

    protected BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            try {
                 String q = intent.getStringExtra(GisService.INFO);
                JSONArray json = new JSONArray(q);
                excursions.clear();
                for (int i = 0; i < json.length(); i++) {
                    Excursion e = new Excursion();
                    JSONObject o = json.getJSONObject(i);
                    if (o.has("city")) {
                        JSONObject c = o.getJSONObject("city");
                        e.setCityName(c.getString("name_ru"));
                    }
                    e.setId(o.getInt("id"));
                    e.setType(o.getString("type"));
                    e.setTitle(o.getString("title"));
                    e.setUrl(o.getString("url"));
                    e.setVisitors(o.getInt("experience_count"));
//                    e.setTours_count(o.getInt("tours_count"));
                    excursions.add(e);
                }
//                JSONObject result_temp = json.getJSONObject("main");
//                JSONObject result_sun = json.getJSONObject("sys");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            adapter.notifyDataSetChanged();
        }
    };
}