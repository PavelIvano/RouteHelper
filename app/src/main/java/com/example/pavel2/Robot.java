package com.example.pavel2;

public class Robot extends Unit {
    protected int armor;

    public Robot(String name, int hp, int armor) {
        super(name, hp);
        this.armor = armor;
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Armor: " + armor);
    }

    public void speak () {
        System.out.println("I am Robot, I can speak");
    }
}
