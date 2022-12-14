package com.liceu.maze.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int number;
    private List<Item> items = new ArrayList<>();

    private boolean target = false;

    private Map<Maze.Directions, MapSite> sides = new HashMap<>();

    public Room(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean isTarget() {
        return target;
    }

    public void setTarget(boolean target) {
        this.target = target;
    }

    public void setItem(Item it) {
        this.items.add(it);
    }

    public MapSite getSide(Maze.Directions dir) {
        return this.sides.get(dir);
    }

    public void setSide(Maze.Directions dir, MapSite ms) {
        this.sides.put(dir, ms);
    }

    public boolean haveKey() {
        for (Item item : items) {
            if (item.getClass() == Key.class) {
                return true;
            }
        }
        return false;
    }

    public boolean haveCoin() {
        for (Item item : items) {
            if (item.getClass() == Coin.class) {
                return true;
            }
        }
        return false;
    }

    public void getKey(Player player) {
        Key key = null;

        for (Item item : items) {
            if (item.getClass() == Key.class) {
                key = (Key) item;

            }
        }
        if (player.getNumCoins() >= key.getCost()) {
            player.addItem(key);
            int count = 0;
            while (count< key.getCost()) {
                player.buy(key, player);
                count++;
            }
            player.buy(key, player);
            items.remove(key);
        }

    }

    public void getCoin(Player player) {
        Coin coin = null;
        for (Item item : items) {
            if (item.getClass() == Coin.class) {
                coin = (Coin) item;
            }
        }
        if (coin != null) {
            player.addItem(coin);
            items.remove(coin);
        }

    }

    public void enter(Player player) {
        for (Item item : items) {
            if (item != null) {
                System.out.println("Has obtingut un ??tem: " + item.toString());
                player.addItem(item);
                item = null;
            }
        }
    }
}
