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
    TextArea minNrOfHighlights;

    @FXML
    CheckBox verifiedCheckBox;

    @FXML
    CheckBox isBusinessAccount;

    @FXML
    CheckBox isRecentlyJoined;

    @FXML
    ComboBox businessCategoryComboBox;

    @FXML
    CheckBox isHaveMailAddress;

    @FXML
    TextField followingFollowerRatioTextField;





    public void searchButtonEvent(ActionEvent e) {
        SearchQuery query = generateQuery();
        String SqlCommand = query.generateSql();
        System.out.println(query);
    }

    public void updateStatusText(String text) {

    }

    private SearchQuery generateQuery() {
        SearchQuery query = new SearchQuery();

        query.setKeywords(this.keywordsTextField.getText());
        query.setMinNrFollowers(Long.parseLong(this.minNumberOfFollowersTextField.getText()));
        query.setMinNrFollowing(Long.parseLong(this.minNumberOfFollowingTextField.getText()));
        query.setVerifiedAccount(this.verifiedCheckBox.isSelected());
        query.setBusinessAccount(this.isBusinessAccount.isSelected());
        query.setRecentlyJoinedAccount(this.isRecentlyJoined.isSelected());
        query.setBusinessCategory("temp");
        query.setHaveMailAddress(this.isHaveMailAddress.isSelected());
        query.setFollowingFollowerRatio(Double.parseDouble(this.followingFollowerRatioTextField.getText()));

        return query;
    }

}
























