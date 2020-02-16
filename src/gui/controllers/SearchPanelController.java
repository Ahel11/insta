package gui.controllers;

import gui.controllerimpl.SearchPanelControllerImpl;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;

public class SearchPanelController {

    SearchPanelControllerImpl searchPanelControllerImpl;
    SearchWindowController windowController;

    public SearchPanelController(SearchWindowController controller) {
        this.windowController = controller;
        searchPanelControllerImpl = new SearchPanelControllerImpl();

        this.searchPanelControllerImpl = new SearchPanelControllerImpl();
        this.searchPanelControllerImpl.setController(this.windowController);
        this.searchPanelControllerImpl.initializePanel();




    }

    public void onQueryButtonClicked(ActionEvent e) {

    }

}
