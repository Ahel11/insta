package gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

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
        if(userNameFieldId.getText().equals("user") && passwordFieldId.getText().equals("pass")) {
            statusId.setText("Login Succes");
        } else {
            statusId.setText("Login Failed");
        }
    }

}






































