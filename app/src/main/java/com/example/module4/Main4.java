package com.example.pavel2.module4;

import java.util.Arrays;
import java.util.Comparator;

public class Main4 {
    public static void main(String[] args) {
        Integer [] a = new Integer [10];
        String[] s = new String[10];
        Arrays.fill(a,10);
        Arrays.fill(s, "Hello");
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(a));

        Integer[] a2 = {21,12,76,51,47};
        Arrays.sort(a2);
        System.out.println(Arrays.toString(a2));

        Integer [] a3 = a2.clone();
        Arrays.sort(a3, new LastDigitComparator());

        System.out.println(Arrays.toString(a3));
    }
}
