package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class DBUser {
    private Statement dbStatement;
    public DBUser(Statement dbStatement) {
        this.dbStatement = dbStatement;
    }

    public Boolean autorisation(String login, String password) throws SQLException {
        Boolean autorisationDone = false;
        String queryText = "SELECT * FROM `Client` WHERE `ClientLogin` = " + login + " AND `ClientPassword` =" + password +";";
        ResultSet resultSet = dbStatement.executeQuery(queryText);
        String dbLogin = resultSet.getString("ClientLogin");
        String dbPassword = resultSet.getString("ClientPassword");
        boolean loginEqual = login.equals(dbLogin);
        boolean passwordEqual = password.equals(dbPassword);
        return (loginEqual == passwordEqual);




    }


}
