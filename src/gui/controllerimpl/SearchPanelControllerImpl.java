package gui.controllerimpl;

import gui.controllers.SearchWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class SearchPanelControllerImpl {

    SearchWindowController controller;

    public void initializePanel() {
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


    public void setController(SearchWindowController controller) {
        this.controller = controller;
    }
}






















