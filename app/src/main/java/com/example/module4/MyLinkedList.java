package com.example.pavel2.module4;

import androidx.annotation.NonNull;

import com.example.pavel2.Robot;
import com.example.pavel2.Unit;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private int size = 0;
    private MyNode<T> head;
    private MyNode<T> tile;

    public void add(T item) {
        MyNode<T> newNode = new MyNode<>();
        newNode.value = item;
        if (tile == null) {
            head = tile = newNode;
            size = 1;
            return;
        }
        tile.next = newNode;
        tile = newNode;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            return null;
        }
        T next = null;
        MyNode<T> cursor = head;
        for (int i = 0; i < index; i++) {
            cursor = cursor.next;
        }
        next = cursor.value;
        return next;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyNode<T> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                T next = cursor.value;
                cursor = cursor.next;
                return next;
            }
        };
    }

    class MyNode<T> {
        protected T value;
        protected MyNode<T> next;
    }

    public static void main(String[] args) {
        MyLinkedList<Unit> myUnits = new MyLinkedList<>();
        myUnits.add(new Unit("R2", 100));
        myUnits.add(new Robot("R2D2", 100, 100));
        myUnits.add(new Robot("R2Dfgh2", 100, 100));
        System.out.println(myUnits);
        System.out.println(myUnits.get(11));
        System.out.println(myUnits.get(1));

        for (Unit next : myUnits) {
            System.out.println(next);
        }
    }
}
