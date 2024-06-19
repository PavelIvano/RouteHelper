package com.example.pavel2.module4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pavel2.R;

import java.util.ArrayList;

public class MonthAdapter extends ArrayAdapter<MyMonth> {
    public MonthAdapter(@NonNull Context context, @NonNull ArrayList<MyMonth> objects) {
        super(context, R.layout.month_list_item, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.month_list_item, null);
        }
        TextView days = convertView.findViewById(R.id.days);
        TextView tmp= convertView.findViewById(R.id.tmp);
        TextView name= convertView.findViewById(R.id.name);

        MyMonth month = getItem(position);

        name.setText(month.getName());
        tmp.setText(month.getTmp() + "");
        days.setText(month.getDays() + "");

        name.setOnClickListener((v) -> {

        });
        convertView.setOnClickListener((v) -> {
            Toast.makeText(getContext(),"" + position, Toast.LENGTH_SHORT).show();
        });

        return convertView;
    }
}
