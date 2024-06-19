package com.example.pavel2.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.pavel2.R;

import java.util.ArrayList;

public class UnitsListActivity extends AppCompatActivity {
    ArrayList<MyMonth> months = new ArrayList<>();
    MonthAdapter adapter;
    ListView monthsLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_units_list);
        months.add(new MyMonth("Январь", -20, 31));
        months.add(new MyMonth("Февраль", -15, 28));
        months.add(new MyMonth("Март", -15, 28));
        months.add(new MyMonth("Апрель", -15, 28));
        months.add(new MyMonth("Май", -15, 28));
        months.add(new MyMonth("Июнь", -15, 28));
        months.add(new MyMonth("Июль", -15, 28));
        months.add(new MyMonth("Август", -15, 28));
        months.add(new MyMonth("Сентябрь", -15, 28));
        months.add(new MyMonth("Октябрь", -15, 28));
        months.add(new MyMonth("Ноябрь", -15, 28));
        months.add(new MyMonth("Дукабрь", -15, 28));
        adapter = new MonthAdapter(getBaseContext(),months);
        monthsLV = findViewById(R.id.monthsLV);
        monthsLV.setAdapter(adapter);
    }
}