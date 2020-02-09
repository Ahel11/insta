package gui.controllerimpl;

import database.DatabaseHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.CometonAccount;

public class LoginControllerImpl {


    public boolean authenticate(String username, String password) {
        DatabaseHandler handler = new DatabaseHandler();
        CometonAccount account = handler.getCometonAccount(username, password);
        if(account != null) {
            return true;
        } else {
            return false;
        }
    }

    public void handleLoginSuccess(Button loginButton) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/Main.fxml"));
            Scene scene = new Scene(root, 900,580);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();

            //Close previous window
            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

















