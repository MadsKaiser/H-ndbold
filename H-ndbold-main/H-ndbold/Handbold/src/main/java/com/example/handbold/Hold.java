package com.example.handbold;

public class Hold {
    private final String name;
    private final int points;
    private final int position;

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
}