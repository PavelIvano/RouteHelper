package com.example.pavel2.module4;

import android.os.Build;

import com.example.pavel2.Unit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class UnitHPComparator implements Comparator<Unit> {
    @Override
    public int compare(Unit u1, Unit u2) {
        return u1.getHp() - u2.getHp();
    }

    public static void main(String[] args) {

        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Unit("h100", 100));
        units.add(new Unit("h50", 50));
        units.add(new Unit("h51", 51));
        units.add(new Unit("h52", 52));
        units.add(new Unit("h53", 53));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            units.sort(new UnitHPComparator());
        }
        System.out.println(units);

        for (Unit next: units) {
            System.out.println(next);
        }
    }
}
