package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> itemList = new ArrayList<>();

    public void setCurrentRoom(Room currentRoom) {

        this.currentRoom = currentRoom;

    }

    public int getNumCoins() {
        int totalCoins = 0;
        for (Item i : itemList) {
            if (i.getClass() == Coin.class) {
                totalCoins++;
            }
        }
        return totalCoins;
    }

    public void buy(Key key, Player player) {
        int counter = 0;
        List<Item> itemList1 = itemList;
        try {
            for (Item i : itemList1) {
                if (key.getCost() > counter && i.getClass() == Coin.class) {
                    itemList.remove(i);
                    counter++;
                }
            }
        } catch (Exception e) {

        }
    }

    public int getNumKeys() {
        int totalKeys = 0;
        for (Item i : itemList) {
            if (i.getClass() == Key.class) {
                totalKeys++;
            }
        }
        return totalKeys;
    }

    public void addItem(Item it) {
        this.itemList.add(it);
    }

    public List<Item> getItemList() {
        return this.itemList;
    }

    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}
