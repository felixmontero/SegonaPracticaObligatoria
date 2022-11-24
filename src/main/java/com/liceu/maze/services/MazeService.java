package com.liceu.maze.services;

import com.liceu.maze.model.*;
import com.liceu.maze.util.MazeBuilder;
import com.liceu.maze.util.StandardMazeBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MazeService {
    public MazeGame createMazeGame(int mazeId) {
        MazeGame mazeGame = new MazeGame();
        Player player = new Player();
        Maze maze = chooseMaze(mazeId);

        try {
            player.setCurrentRoom(maze.getRoom(1));
        } catch (NullPointerException e) {

        }



        mazeGame.setMaze(maze);
        mazeGame.setPlayer(player);
        return mazeGame;
    }



    private static void go(Player player, Maze.Directions dir) {
        Room room = player.getCurrentRoom();
        MapSite ms = room.getSide(dir);
        ms.enter(player);
    }
    private Maze chooseMaze(int id) {
        switch (id) {
            case 1:
                return createMaze();
            case 2:
                return createMaze2();
            default:
                return null;
        }
    }

    private static Maze createMaze() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();

        mazeBuilder.setIdMaze(1);
        mazeBuilder.setNameMaze("Mapa 1");
        IntStream
                .range(1, 7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key", 2);
        Key k2 = new Key("Level2 Key", 1);

        mazeBuilder.buildDoor(1, 2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1, 4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1, 5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1, 3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5, 6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }

    private static Maze createMaze2() {
        MazeBuilder mazeBuilder = new StandardMazeBuilder();

        mazeBuilder.setIdMaze(2);
        mazeBuilder.setNameMaze("Mapa 2");

        IntStream
                .range(1, 7)
                .forEach(mazeBuilder::buildRoom);

        Key k1 = new Key("Level1 Key", 2);
        Key k2 = new Key("Level2 Key", 1);

        mazeBuilder.buildDoor(1, 2, Maze.Directions.NORTH);
        mazeBuilder.buildDoor(1, 4, Maze.Directions.SOUTH);
        mazeBuilder.buildDoor(1, 5, Maze.Directions.EAST);

        mazeBuilder.buildDoor(1, 3, Maze.Directions.WEST, k2);
        mazeBuilder.buildDoor(5, 6, Maze.Directions.EAST, k1);

        mazeBuilder.putKeyInRoom(6, k2);
        mazeBuilder.putKeyInRoom(2, k1);

        mazeBuilder.setTarget(3);

        return mazeBuilder.getMaze();
    }

    public List<Maze> mazeList() {
        List<Maze> mazeLists = new ArrayList<>();
        mazeLists.add(createMaze());
        mazeLists.add(createMaze2());

        return mazeLists;

    }

    public String getJsonInfo(MazeGame mazeGame) {
        JSONObject root = new JSONObject();
        JSONObject walls = new JSONObject();
        JSONObject player = new JSONObject();
        JSONArray array = new JSONArray();
        //añadir las propiedades del jugador
        Room playerRoom = mazeGame.getPlayer().getCurrentRoom();
        player.put("currentRoom", playerRoom.getNumber());
        //añadir inventario (faltan implementar los metodos)
        player.put("coins", mazeGame.getPlayer().getNumCoins());
        player.put("keys", mazeGame.getPlayer().getNumKeys());

        //muros

        MapSite dirNorth =playerRoom.getSide(Maze.Directions.NORTH);
        MapSite dirWest =playerRoom.getSide(Maze.Directions.WEST);
        MapSite dirSouth =playerRoom.getSide(Maze.Directions.SOUTH);
        MapSite dirEast =playerRoom.getSide(Maze.Directions.EAST);
        walls.put("n", dirTest(dirNorth));
        walls.put("w",  dirTest(dirWest));
        walls.put("s",  dirTest(dirSouth));
        walls.put("e",  dirTest(dirEast));

        JSONObject room = new JSONObject();
        room.put("walls", walls);
        //room.put("coin", currentRoom.haveCoin());
        //room.put("key", currentRoom.haveKey());

        root.put("player", player);
        root.put("room", room);

        return root.toJSONString();
    }

    public Object dirTest( MapSite i) {

        if (i.getClass() == Wall.class) {
            JSONObject wall = new JSONObject();
            wall.put("type","wall");
            return wall;
        }

        JSONObject door = new JSONObject();
        door.put("type", "door");
        Door doorOpen = (Door)i;
        door.put("open",doorOpen);

        return door;
    }

}
