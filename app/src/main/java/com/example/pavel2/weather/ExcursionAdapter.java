package com.example.pavel2.weather;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.pavel2.Quest.StartActivity;
import com.example.pavel2.R;

import java.util.ArrayList;

public class ExcursionAdapter extends ArrayAdapter<Excursion> {
    public ExcursionAdapter(Context context, ArrayList<Excursion> arr) {
        super(context, R.layout.adapter_item, arr);
    }
    public View getView(int position, View convertView, ViewGroup parent) {

        final Excursion ex = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, null);
        }

        ((TextView) convertView.findViewById(R.id.textView)).setText(ex.getTitle());
        convertView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(getContext(), ExcursionActivity.class);
                        i.putExtra("position", position);
                        MainActivity a = (MainActivity) getContext();
                        a.startActivity(i);
                    }
                }
        );


        return convertView;
    }
}
