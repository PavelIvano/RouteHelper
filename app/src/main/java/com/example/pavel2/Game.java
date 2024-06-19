package com.example.pavel2;

public class Game<T> {
    T[] players;
    int count = 0;
    public Game() {
        players = (T[]) new Object[10];
    }

    public void start() {
        System.out.println("Game started");
    }
    public void addPlayer(T player) {
        players[count++] = player;
    }

    public T getItem() {
        return players[0];
    }

    public static void main(String[] args) {
        Game<Robot> g = new Game<>();
        g.addPlayer(new Robot("r2d2", 100, 100));
        System.out.println(g.getItem().armor);
        g.start();

        Game<Terminator> g2 = new Game<>();
        g.addPlayer(new Robot("r2d2", 100, 100));
        System.out.println(g2.getItem().gun);
        g.start();
    }
}
