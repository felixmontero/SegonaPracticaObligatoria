package com.liceu.maze.model;

public class Wall implements MapSite {
    @Override
    public void enter(Player player) {
        System.out.println("No pots passar a través d'una paret");
    }
}
