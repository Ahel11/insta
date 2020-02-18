package gui.controllers;

import gui.HolderCont;
import gui.controllerimpl.LoginControllerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class GuiController {

    @FXML
    private Label statusId;

    @FXML
    private TextField userNameFieldId;

    @FXML
    private TextField passwordFieldId;

    @FXML
    private Button LoginButtonId;

    public void LoginButton(ActionEvent event) {
        String username = userNameFieldId.getText();
        String password = passwordFieldId.getText();
        HolderCont.userName = username;
        LoginControllerImpl loginController = new LoginControllerImpl();
        boolean authenticationStatus = loginController.authenticate(username, password);

        if(authenticationStatus) {
            statusId.setText("Login Succes");
            loginController.handleLoginSuccess(LoginButtonId);
        } else {
            statusId.setText("Login Failed");
        }
    }


    private void launchMainScreen() {

    }

}






































