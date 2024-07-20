package com.femcoders.model;

import java.sql.Connection;
import java.sql.DriverManager;

import io.github.cdimascio.dotenv.Dotenv;

public class DBManager {
    
    static Dotenv dotenv = Dotenv.load();

    private static final String url = "jdbc:postgresql://localhost:5432/library?charSet=UTF8";
    private static final String user = dotenv.get("DB_USER");
    private static final String pass = dotenv.get("DB_PASS");
    private static Connection connection;

    public static Connection initConnection() {
        try {
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("\033[0;32m" + "\n¡Conectado con éxito!" + "\033[0m");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try {
            connection.close();
            System.out.println("\033[0;32m" + "Has salido del sistema correctamente" + "\033[0m");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
