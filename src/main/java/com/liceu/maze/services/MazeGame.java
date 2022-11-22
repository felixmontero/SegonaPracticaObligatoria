package com.liceu.maze.services;

import com.liceu.maze.model.Maze;
import com.liceu.maze.model.Player;

public class MazeGame {
    private Player player;
    private Maze maze;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }
}
