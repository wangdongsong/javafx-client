package com.wds.main;

import com.wds.Application;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class MainController {

    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;


    @FXML
    protected void handleSignIn() {
        System.out.println(userNameField.getText() + "-" + passwordField.getText());
        Application.setRoot("index/index");
    }

}
