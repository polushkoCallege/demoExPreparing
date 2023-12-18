package com.example.demo1;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

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
    private ListView<HBox> cartListView;

    @FXML
    private ListView<String> catalogListView;

    @FXML
    private AnchorPane testAnchorPane;

    @FXML
    void initialize() throws SQLException {
        DBProduct dbProduct = new DBProduct(DBConnector.createConnection());

        LinkedList<String> dbProductDescription = dbProduct.getProductsDescription();
        LinkedList<String> dbProductPhoto = dbProduct.getProductsPhoto();
        ObservableList<HBox> catalogElements = FXCollections.observableArrayList();

        Integer dbProductsQuantity = dbProduct.getProductsQuantity();

        for (int tick = 0; tick < dbProductsQuantity; tick++) {
            catalogElements.add(loadInfo(dbProductDescription.get(tick), dbProductPhoto.get(tick)));
        }

        cartListView.setItems(catalogElements);
    }

    HBox loadInfo(String productName, String productPhotoLink) throws SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("product-cart.fxml"));
        Parent parent = null;
        try {
            parent = (Parent) fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Label name = (Label) parent.lookup("#productLabel");
        name.setText(productName);

        File file = new File(productPhotoLink);
        ImageView image = (ImageView) parent.lookup("#productImageView");
        Image image1 = null;
        URL url = getClass().getResource(productPhotoLink);
        image1 = new Image(url.toExternalForm());

        image.setPreserveRatio(true);
        image.setImage(image1);

        return (HBox) parent.lookup("#idStr");

    }

}