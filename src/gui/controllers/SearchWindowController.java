package gui.controllers;

import gui.controllerimpl.SearchWindowControllerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;


public class SearchWindowController {

    @FXML
    TextArea statusDialog;

    @FXML
    Button searchButton;

    @FXML
    Label resultsLeftLabel;

    public void searchButtonEvent(ActionEvent e) {
        SearchWindowControllerImpl controller = new SearchWindowControllerImpl();
        controller.handleSearchWindowButtonEvent();
    }

}
























