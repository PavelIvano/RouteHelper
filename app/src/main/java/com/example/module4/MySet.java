package com.example.pavel2.module4;

import java.util.ArrayList;
import java.util.Arrays;

public class MySet<T> {

    private ArrayList<T>[] data;

    public MySet() {
        data = new ArrayList[7];
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = new ArrayList<>();
        }
    }

    public boolean add(T value) {
        int hash = value.hashCode();
        int column = hash % this.data.length;
        if (this.data[column].contains(value)) {
            this.data[column].add(value);
            return true;
        } else {
            return false;
        }
    }
    public boolean remove(T value) {
        int hash = value.hashCode();
        int column = hash % this.data.length;
        return this.data[column].remove(value);
    }
}
