package com.example.pavel2.module4;

import androidx.annotation.NonNull;

import com.example.pavel2.Robot;
import com.example.pavel2.Unit;

import java.util.Iterator;
import java.util.List;

public class MyArrayList<T> implements Iterable<T> {
    T[] items;
    int size;

    public MyArrayList() {
        items =(T[]) new Object[10];
        size = 0;
    }
    public void add(T item) {
        if (items.length == size) {
            T[] arr2 = (T[]) new Object[items.length * 2];
            System.arraycopy(items, 0, arr2, 0, size);
            this.items = (T[]) arr2;
        }
        items[size] = item;
        size++;
    }
    public T get(int index) {
        if (index < 0 || index > items.length -1) {
            return null;
        }
        return items[index];
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private  int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return items[cursor++];
            }
        };
    }

    public static void main(String[] args) {
        MyArrayList<Unit> myUnits = new MyArrayList<>();
        myUnits.add(new Unit("R2", 100));
        myUnits.add(new Robot("R2D2", 100, 100));
        System.out.println(myUnits);
        System.out.println(myUnits.get(11));

        for (Unit next: myUnits) {
            System.out.println(next);
        }
    }
}
