package com.example.demo1;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AdminHelloView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text infoText;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private Button registrationButton;

    @FXML
    void initialize() throws SQLException {
        DBUser admin = new DBUser(DBConnector.createConnection());



        registrationButton.setOnAction(event -> {
            String login = loginField.getText();
            String password = passwordPasswordField.getText();
            Boolean connectionDone = admin.authorisation(login, password);
            if (connectionDone) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("admin-panel.fxml"));
                try {
                    Stage stage = (Stage) registrationButton.getScene().getWindow();
                    stage.close();
                    loader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                Parent root = loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.showAndWait();

            }
            else {
                infoText.setText("Wrong password");
            }
        });



    }



}