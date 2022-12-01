package com.liceu.maze.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionDAO {

    static Connection getConnection () {

        Connection connection;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            connection = DriverManager.getConnection(

                    "jdbc:mysql://mysql:3307/maze",
                    "root",
                    "root"
            );
            return connection;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
