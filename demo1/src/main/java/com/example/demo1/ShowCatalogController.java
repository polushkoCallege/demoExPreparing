package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import java.util.LinkedList;

public class ShowCatalogController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addButton;

    @FXML
    private Button backButton;

    @FXML
    private AnchorPane cartScrollPane;

    @FXML
    private AnchorPane catalogScrollPane;

    @FXML
    private Button nextButton;

    @FXML
    void initialize() throws SQLException {

        DBProduct dbProduct = new DBProduct(DBConnector.createConnection());
        LinkedList<String> dbProducts = dbProduct.getProductsDescription();

        for (int product = 0; product < dbProducts.size(); product ++) {
            catalogScrollPane.getChildren().add(new Label(dbProducts.get(product)));
        }





    }

}