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

    public Key() {

    }

    public void addDoor(Door d) {
        this.doors.add(d);
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKeyCoins() {
        return keyCoins;
    }

    public void setKeyCoins(int keyCoins) {
        this.keyCoins = keyCoins;
    }

    public void open(Door door) {
        this.doors
                .stream()
                .filter(d -> d.equals(door))
                .forEach(Door::open);
    }

    public int getCost() {
        return keyCoins;
    }

    public  boolean openDoor(Door door){
        open(door);
        return  false;
    }
    @Override
    public String toString() {
        return "Key";
    }

    public boolean getDoorKey(Door door, List<Item> itemList) {
        for (Item it : itemList){
            if (it instanceof  Key){
                Key key = (Key) it;
                if (key.getDoors().contains(door)){
                    return true;
                }
            }
        }
        return false;
    }
}







