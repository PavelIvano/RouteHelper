package com.example.pavel2;

import java.util.Objects;

public class  Unit implements Speakable {
    protected int hp;
    protected String name;

    @Override
    public String toString() {
        return "Unit{" +
                "hp=" + hp +
                ", name='" + name + '\'' +
                '}';
    }

    public Unit(String name, int hp) {
        this.hp = hp;
        this.name = name;
    }



    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("HP: " +hp);
    }

    @Override
    public void speak() {
        System.out.println("I am Unit, I can speak");
    }

    public int getHp() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return hp == unit.hp && Objects.equals(name, unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hp, name);
    }
}
