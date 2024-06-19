package com.example.pavel2.module4;

public class MyMonth {
    private String name;
    private int tmp;
    private int days;

    public MyMonth(String name, int tmp, int days) {
        this.name = name;
        this.tmp = tmp;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public int getTmp() {
        return tmp;
    }

    public int getDays() {
        return days;
    }
}
