package com.example.pavel2.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import com.example.pavel2.R;

public class FragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        MyFragment fragment = new MyFragment();
        ft.add(R.id.samsung_container,fragment,"fragment:1");

        ft.commit();

        ft = fm.beginTransaction();
        ButtonsFragment bf = new ButtonsFragment();
        ft.add(R.id.button_container, bf,"fragment:2");
        ft.commit();




    }
}