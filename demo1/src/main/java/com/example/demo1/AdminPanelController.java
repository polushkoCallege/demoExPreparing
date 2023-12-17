package com.example.demo1;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminPanelController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button addProductButton;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TextField idTextField;

    @FXML
    private TextField photoTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField removeIdTextField;

    @FXML
    private Button removeProductButton;

    @FXML
    void initialize() {
        addProductButton.setOnAction(event -> {
            String idString = idTextField.getText();
            String photoLinkString = photoTextField.getText();
            String descriptionString = descriptionTextField.getText();
            String priceString = priceTextField.getText();

            String query = "INSERT INTO `Product` (`ProductId`, `ProductPhoto`, `ProductDescription`, `ProductPrice`) VALUES (NULL, '"+ photoLinkString +"', '"+ descriptionString +"', '"+ priceString +"');";
            try {
                DBProduct dbProduct = new DBProduct(DBConnector.createConnection());
                dbProduct.addProduct(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        });

        // TODO: 12/17/2023 What u will do with remove item  
        // TODO: 12/17/2023 You add catalog style listView? 

    }

}