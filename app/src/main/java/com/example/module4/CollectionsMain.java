package com.example.pavel2.module4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

import com.example.pavel2.Unit;

import javax.xml.transform.Source;

public class CollectionsMain {
    public static void main(String[] args) {
        ArrayList<Unit> list = new ArrayList<>();
        fillAndPrint(list);

        System.out.println("___________");

        LinkedList<Unit> list2 = new LinkedList<>();
        fillAndPrint(list2);
    }

    public static void fillAndPrint(List<Unit> list) {
        list.add(new Unit("R1", 101));
        list.add(new Unit("R2", 102));
        list.add(new Unit("R3", 103));
        list.add(new Unit("R4", 104));
        list.add(new Unit("R5", 105));

        list.remove(2);

        list.set(0, new Unit("R0", 123));

        for (Unit n: list) {
            System.out.println(n);
        }

    }
}
