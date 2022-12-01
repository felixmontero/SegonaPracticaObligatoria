package com.liceu.maze.model;
// Creamos la clase winners que (la misma que la base de datos) para poder obtener información de ella

public class Winners {

    private int id;
    private String name;
    private Maze map_name;
    private long elapsed_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Maze getMap_name() {
        return map_name;
    }

    public void setMap_name(Maze map_name) {
        this.map_name = map_name;
    }

    public long getElapsed_time() {
        return elapsed_time;
    }

    public void setElapsed_time(long elapsed_time) {
        this.elapsed_time = elapsed_time;
    }
}
