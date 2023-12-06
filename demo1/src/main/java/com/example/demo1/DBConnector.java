package com.example.demo1;

import java.sql.*;

import java.util.LinkedList;

public class DBConnector {
    private String host = "localhost";
    private String port = "3306";
    private String dbName = "ShopDemo";
    private String login = "root";
    private String password = "";


    public Statement createConnection() throws SQLException {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?characterEncoding=UTF8" + "&useSSL=false&allowPublicKeyRetrieval=true";
                //"jdbc:mysql://" + host + ":" + port + "//" + dbName;
        Connection connection = DriverManager.getConnection(url, login, password);
        return connection.createStatement();
    }

}
