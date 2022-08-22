package com.valmojr.guardian.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    public static Connection createConnectionToMySQLDatabase() throws Exception{
        String url = "jdbc:mysql://localhost:3306/guardian";
        String username = "root";
        String password = "";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static Connection createConnection(String url, String username, String password) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}