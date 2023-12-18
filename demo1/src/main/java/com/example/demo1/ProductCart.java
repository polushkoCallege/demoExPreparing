package com.example.demo1;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ProductCart {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView productImageView;

    @FXML
    private Label productLabel;

    @FXML
    void initialize() {
        Image image = new Image (getClass().getResourceAsStream("/img/1.jpg"));
        productImageView.setImage(image);
    }


}