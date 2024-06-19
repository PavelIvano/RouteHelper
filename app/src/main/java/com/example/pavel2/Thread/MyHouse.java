package com.example.pavel2.Thread;

public class MyHouse {
    protected boolean pizza = false;
    public synchronized void eatPizza() {
        while (!pizza) {
            System.out.println("......");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("yumyum");
    }
    public synchronized void pizzaGuy() {
        pizza = true;
        notifyAll();
    }

    public static void main(String[] args) throws InterruptedException {
        MyHouse house = new MyHouse();
        new Thread(() -> house.eatPizza()).start();

        Thread.sleep(3000);
        house.pizzaGuy();
    }
}
