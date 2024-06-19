package com.example.pavel2.Quest;

public class Situation {
    private String title;
    private String description;
    private int dK;
    private int dR;
    private int dA;
    private Situation[] directions;

    public Situation(String title, String description, int dK, int dR, int dA, int answers) {
        this.title = title;
        this.description = description;
        this.dK = dK;
        this.dR = dR;
        this.dA = dA;
        this.directions = new Situation[answers];
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getdK() {
        return dK;
    }

    public void setdK(int dK) {
        this.dK = dK;
    }

    public int getdR() {
        return dR;
    }

    public void setdR(int dR) {
        this.dR = dR;
    }

    public int getdA() {
        return dA;
    }

    public void setdA(int dA) {
        this.dA = dA;
    }

    public Situation[] getDirections() {
        return directions;
    }

    public void setDirections(Situation[] directions) {
        this.directions = directions;
    }
}
