package com.example.pavel2.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.pavel2.R;

import java.util.ArrayList;

public class SaveActivity extends AppCompatActivity {
    EditText enterET;
    Button saveBTN;
    ListView words;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> wordsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
        enterET = this.findViewById(R.id.enterET);
        saveBTN = this.findViewById(R.id.saveBTN);
        words = this.findViewById(R.id.words);

        wordsAdapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, list);
        words.setAdapter(wordsAdapter);

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = enterET.getText().toString();
                if (text.length()> 0) {
                    list.add(text);
                    wordsAdapter.notifyDataSetChanged();
                }
                enterET.setText("");


            }
        });
    }
}