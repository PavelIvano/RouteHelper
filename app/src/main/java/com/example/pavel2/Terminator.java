package com.example.pavel2;

public class Terminator<gun> extends Robot {
    protected String gun;

    public Terminator(String name, int hp, int armor, String gun) {
        super(name, hp, armor);
        this.gun = gun;
    }
    public Terminator(String name, int hp, int armor) {
        super(name, hp, armor);
        this.gun = "Rogatka";
    }


    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Gun: " + gun);
    }
    public void speak() {
        System.out.println("I am Terminator, I can Speak");
    }
}
