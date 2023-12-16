package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class DBAdmin {
    private Statement dbStatement;
    public DBAdmin(Statement dbStatement) {
        this.dbStatement = dbStatement;
    }

    public Boolean authorisation(String login, String password){
        Boolean authorisationDone = false;
        String queryText = "SELECT * FROM Admin WHERE `AdminLogin` = '" + login + "' and `AdminPassword` = '" + password +"'";
        //String queryText = "SELECT * FROM Client WHERE `ClientLogin` = 'login' and `ClientPassword` = 'password'";
        try {
            ResultSet resultSet = dbStatement.executeQuery(queryText);
            resultSet.next();
            String dbLogin = resultSet.getString("ClientLogin");
            String dbPassword = resultSet.getString("ClientPassword");
            if ((Objects.equals(dbLogin, login)) && (Objects.equals(dbPassword, password))) {
                authorisationDone = true;
            }
            return authorisationDone;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


}
