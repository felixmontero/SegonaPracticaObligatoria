package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.List;

public class Key implements Item {
    private List<Door> doors = new ArrayList<>();
    private String name;
    private int keyCoins;

    public Key(String name,int keyCoins) {
        this.name = name;
        this.keyCoins = keyCoins;
    }

    public void addDoor(Door d) {
        this.doors.add(d);
    }

    public void open(Door door) {
        this.doors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

    @Override
    public String toString() {
        return "Key";
    }
}







