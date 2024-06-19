package com.example.pavel2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class RegActivity extends AppCompatActivity {
    EditText nameET;
    EditText phoneET;
    RadioButton m;
    RadioButton w;
    EditText adrET;
    Button regBtn;
    Button geoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        nameET = this.findViewById(R.id.nameTv);
        phoneET = this.findViewById(R.id.phoneET);
        m = this.findViewById(R.id.m);
        w = this.findViewById(R.id.w);
        adrET = this.findViewById(R.id.adrET);
        regBtn = this.findViewById(R.id.regBtn);
        geoBtn = this.findViewById(R.id.geoBtn);

        geoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(), TakeActivity.class);
                startActivity(i);
            }
        }

        );

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(getBaseContext(),AccountActivity.class);
                i.putExtra("name", nameET.getText().toString());
                i.putExtra("man", m.isChecked());
                i.putExtra("phone", phoneET.getText().toString());
                i.putExtra("address", adrET.getText().toString());
                startActivity(i);
            }
        });
    }
}