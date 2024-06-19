package com.example.pavel2.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pavel2.R;

import java.util.ArrayList;

public class ExcursionAdapter2 extends ArrayAdapter<Excursion> {

    public ExcursionAdapter2(Context context, ArrayList<Excursion> arr) {
        super(context, R.layout.adapter_item2, arr);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final Excursion ex = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getId());
        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getType());
        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getTitle());
        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getUrl());
        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getVisitors());

        return convertView;
    }
}
