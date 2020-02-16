package gui.controllers;

import gui.controllerimpl.SearchWindowControllerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.SearchQuery;

import java.awt.*;
import java.io.File;


public class SearchWindowController {

    @FXML
    TextArea statusDialog;

    @FXML
    Button searchButton;

    @FXML
    Label resultsLeftLabel;

    @FXML
    TextField keywordsTextField;

    @FXML
    TextField minNumberOfFollowingTextField;

    @FXML
    TextField minNumberOfFollowersTextField;

    @FXML
    TextArea numberOfHighlightsTextField;

    @FXML
    Checkbox isVerifiedCheckBox;

    @FXML
    Checkbox isBusinessAccountCheckBox;

    @FXML
    Checkbox isRecentlyJoinedCheckBox;

    @FXML
    ComboBox businessCategoryComboBox;

    @FXML
    Checkbox isHaveMailAddressCheckBox;

    @FXML
    TextField followingFollowerRatioTextField;





    public void searchButtonEvent(ActionEvent e) {
        SearchQuery query = generateQuery();
        System.out.println(query);
    }

    public void updateStatusText(String text) {

    }

    private SearchQuery generateQuery() {
        SearchQuery query = new SearchQuery();

        query.setKeywords(this.keywordsTextField.getText());
        query.setMinNrFollowers(Long.parseLong(this.minNumberOfFollowersTextField.getText()));
        query.setMinNrFollowing(Long.parseLong(this.minNumberOfFollowingTextField.getText()));
        query.setMinNrOfHighLights(Long.parseLong(this.numberOfHighlightsTextField.getText()));
        query.setVerifiedAccount(this.isVerifiedCheckBox.getState());
        query.setBusinessAccount(this.isBusinessAccountCheckBox.getState());
        query.setRecentlyJoinedAccount(this.isRecentlyJoinedCheckBox.getState());
        query.setBusinessCategory("temp");
        query.setHaveMailAddress(this.isHaveMailAddressCheckBox.getState());
        query.setFollowingFollowerRatio(Long.parseLong(this.followingFollowerRatioTextField.getText()));

        return query;
    }

}
























