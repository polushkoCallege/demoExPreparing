package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.security.cert.TrustAnchor;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.events.MouseEvent;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registrationButton;


    @FXML
    private Button showPasswordButton;


    @FXML
    private Button skipButton;


    DBConnector dbConnector = null;
    DBUser dbUser = null;

    String login = "";
    String password = "";

    @FXML
    void initialize() throws SQLException {

        passwordTextField.setVisible(false);

        showPasswordButton.setOnAction(new EventHandler<ActionEvent>() {
            Boolean isShown = false;
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!isShown) {
                    showPasswordButton.setText("Hide password");
                    String password = passwordPasswordField.getText();
                    passwordPasswordField.setVisible(false);
                    passwordTextField.setVisible(true);
                    passwordTextField.setText(password);
                    isShown = true;
                }
                else {
                    showPasswordButton.setText("Show password");
                    String password = passwordPasswordField.getText();
                    passwordPasswordField.setVisible(true);
                    passwordTextField.setVisible(false);
                    passwordTextField.setText(password);
                }



            }
        });

        dbConnector = new DBConnector();
        dbUser = new DBUser(dbConnector.createConnection());


        registrationButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                login = loginField.getText();
                password = passwordPasswordField.getText();

                Boolean userAutorise = null;
                try {
                    userAutorise = dbUser.autorisation(login, password);
                    if (userAutorise) {
                        registrationButton.setText("good");
                    }
                    else {
                        registrationButton.setText("pidr");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        skipButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("show-catalog.fxml"));
                Stage stage = new Stage();
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(), 620, 540);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage.setTitle("Просмотр списка студентов");
                stage.setScene(scene);
            }
        });



    }

}
