package com.example.demo1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("show-catalog.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Book club");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        //TODO create the administrative account button here(autorisation and adding products in admin fxml)

        DBUser dbUser = new DBUser(DBConnector.createConnection());
        System.out.println(dbUser.authorisation("login", "password"));
        System.out.println(1);
        DBProduct dbProduct = new DBProduct(DBConnector.createConnection());
        System.out.println(dbProduct.getProductsDescription());


        launch();

    }
}