package gui.controllerimpl;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SearchWindowControllerImpl {

    public void handleSearchWindowButtonEvent() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/gui/SearchPanel.fxml"));
            Scene scene = new Scene(root, 900,580);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}




























