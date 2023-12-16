package com.example.demo1;

import java.sql.*;

import java.util.LinkedList;

public class DBConnector {
    private static String host = "localhost";
    private static String port = "3306";
    private static String dbName = "ShopDemo";
    private static String login = "root";
    private static String password = "";


    public static Statement createConnection() throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?characterEncoding=UTF8" + "&useSSL=false&allowPublicKeyRetrieval=true";
                //"jdbc:mysql://" + host + ":" + port + "//" + dbName;
        Connection connection = DriverManager.getConnection(url, login, password);
        return connection.createStatement();
    }




}
