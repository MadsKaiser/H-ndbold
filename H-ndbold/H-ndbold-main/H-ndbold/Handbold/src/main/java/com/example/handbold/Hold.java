package com.example.handbold;

public class Hold {
    private String name;
    private int points;
    private int position;

    public Hold(String name, int points, int position) {
        this.name = name;
        this.points = points;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return position + ", " + name + ", " + points;
    }
}