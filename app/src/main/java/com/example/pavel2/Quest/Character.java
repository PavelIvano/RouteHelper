package com.example.pavel2.Quest;

public class Character {
    private String name;
    private int k;
    private int r;
    private int a;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Ваш статус" +
                ", k=" + k +
                ", r=" + r +
                ", a=" + a +
                '}';
    }
}
