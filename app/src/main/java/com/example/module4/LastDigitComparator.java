package com.example.pavel2.module4;

import java.util.Comparator;

public class LastDigitComparator implements Comparator <Integer> {
    @Override
    public int compare(Integer i1, Integer i2) {
        return i1%10 - i2%10;
    }
}
