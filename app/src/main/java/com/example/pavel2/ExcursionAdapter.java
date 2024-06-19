package com.example.pavel2;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.example.pavel2.weather.Excursion;

import java.util.ArrayList;

public class ExcursionAdapter extends ArrayAdapter<Excursion> {
    public ExcursionAdapter(Context context, ArrayList<Excursion> arr) {
        super(context, R.layout.adapter_item, arr);
    }
}
