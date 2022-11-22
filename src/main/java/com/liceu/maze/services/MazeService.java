package com.liceu.maze.services;

import com.liceu.maze.model.Key;
import com.liceu.maze.model.Maze;
import com.liceu.maze.util.MazeBuilder;
import com.liceu.maze.util.StandardMazeBuilder;

import java.util.stream.IntStream;

public class MazeService {

    public MazeGame createMazeGame(String mazeId){


    if(convertToNumberTest(mazeId)){



    }
    return null;
    }

    private static Maze createMaze() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();
        IntStream
                .range(1,7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key",2);
        Key k2 = new Key("Level2 Key",1);

        mazeBuilder.buildDoor(1,2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1,4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1,5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1,3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5,6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }

    boolean convertToNumberTest(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
