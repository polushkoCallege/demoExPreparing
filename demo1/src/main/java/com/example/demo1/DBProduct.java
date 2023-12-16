package com.example.demo1;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;


public class DBProduct {
    private Statement dbStatement;

    public DBProduct(Statement dbStatement) {
        this.dbStatement = dbStatement;
    }

    public LinkedList<String> getProductsDescription()  {
        String queryText = "SELECT ProductDescription FROM `Product`;";
        try {
            Integer productsQuantity = getProductsQuantity();
            LinkedList<String> productName = new LinkedList<>();
            ResultSet resultSet = dbStatement.executeQuery(queryText);
            resultSet.next();
            while (productsQuantity >= 1) {
                productName.add(resultSet.getString("ProductDescription"));
                resultSet.next();
                productsQuantity -= 1;
            }
            return productName;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getProductsQuantity(){
        String query = "SHOW TABLE STATUS LIKE 'Product'; ";
        ResultSet resultSet = null;
        try {
            resultSet = dbStatement.executeQuery(query);
            resultSet.next();
            return resultSet.getInt("Rows");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
