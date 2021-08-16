package com.dungeon.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Configuration {
    private static final String name = "postgres";
    private static final String password = "admin";
    private static final String connectionUrl = "jdbc:postgresql://localhost:5432/ddd";
    private static Connection connection;
    public static void initConnection(){
        try {
            Class.forName("org.postgresql.Driver");
             connection= DriverManager.getConnection(connectionUrl, name,password);

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static  Connection getConnection() {
       return connection;
    }
    public static void closeConnection(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
