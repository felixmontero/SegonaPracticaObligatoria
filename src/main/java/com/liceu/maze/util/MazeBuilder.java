package com.liceu.maze.util;

import com.liceu.maze.model.Coin;
import com.liceu.maze.model.Item;
import com.liceu.maze.model.Key;
import com.liceu.maze.model.Maze;

public interface MazeBuilder {
    void buildRoom(int nroom);
    void setTarget(int nroom);
    void buildDoor(int roomFrom, int roomTo, Maze.Directions dir);
    void buildDoor(int roomFrom, int roomTo, Maze.Directions dir, Key key);
    void putKeyInRoom(int nroom, Key key);
    public void putCoinInRoom(int nRoom, Coin coin);

    void setNameMaze(String nameMaze);
    void setIdMaze(int mazeId);
    Maze getMaze();
}
