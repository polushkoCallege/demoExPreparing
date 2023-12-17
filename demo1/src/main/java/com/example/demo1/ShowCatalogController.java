package com.example.demo1;

import java.net.URL;
import java.sql.Array;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

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
    private ListView<String> cartListView;

    @FXML
    private ListView<String> catalogListView;

    @FXML
    void initialize() throws SQLException {

        DBProduct dbProduct = new DBProduct(DBConnector.createConnection());
        LinkedList<String> dbProducts = dbProduct.getProductsDescription();
        ObservableList<String> catalogElements = FXCollections.observableArrayList();
        for (int x = 0; x < dbProducts.size(); x++) {
            catalogElements.add(dbProducts.get(x));
        }
        catalogListView.setItems(catalogElements);


        // TODO: 12/17/2023 fix the cart actions
        addButton.setOnAction(event -> {
            ObservableList<String> selectedItems = catalogListView.getSelectionModel().getSelectedItems();
            cartListView.setItems(selectedItems);
        });






    }

}