package com.example.pavel2.module4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SoundEffectConstants;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pavel2.R;

import java.util.Arrays;

public class NewMatchActivity extends AppCompatActivity {
    EditText t1Et, t2Et, p1Et, p2Et;
    Button save, all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_match);
        t1Et = findViewById(R.id.team1);
        t2Et = findViewById(R.id.team2);
        p1Et = findViewById(R.id.points1);
        p2Et = findViewById(R.id.points2);
        save = findViewById(R.id.save);
        all = findViewById(R.id.all);
        save.setOnClickListener(this::saveClick);
        all.setOnClickListener(this::allClick);

    }
    public  void saveClick(View v) {
        String t1 = t1Et.getText().toString();
        String t2 = t1Et.getText().toString();
        String p1S = p1Et.getText().toString();
        String p2S = p2Et.getText().toString();
        if(t1.isEmpty() || t2.isEmpty()|| p1S.isEmpty() || p2S.isEmpty()) {
            Toast.makeText(this, "Заполни все поля", Toast.LENGTH_SHORT).show();
            return;
        }
        int p1 = Integer.parseInt(p1S);
        int p2 = Integer.parseInt(p2S);

        Match m = new Match(t1, t2, p1, p2);
        DBMatches dbMatches = new DBMatches(this);
        dbMatches.insert(m);

        t1Et.setText("");
        t2Et.setText("");
        p1Et.setText("");
        p2Et.setText("");

    }
    public  void allClick(View v) {
        DBMatches dbMatches = new DBMatches(this);
        System.out.println(Arrays.toString(
                dbMatches.selectAll().toArray()
        ));
    }
}