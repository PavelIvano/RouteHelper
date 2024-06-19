package com.example.pavel2.Thread;

public class ThreadMain extends Thread {
    public String letter;
    public ThreadMain (String letter) {
        this.letter = letter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(letter);

        }
    }

    public static void main(String[] args) {
        ThreadMain tm1 = new ThreadMain("A");
        ThreadMain tm2 = new ThreadMain("B");
        ThreadMain tm3 = new ThreadMain("C");
        tm1.start();
        tm2.start();
        tm3.start();

    }
}
