package gui.controllers;

import database.DatabaseHandler;
import gui.HolderCont;
import gui.controllerimpl.SearchWindowControllerImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import me.postaddict.instagram.scraper.Instagram;
import model.InstagramUserRecord;
import model.SearchQuery;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class SearchWindowController implements Initializable {

    private DatabaseHandler handler;
    private Long nrOfQueriesLeftLong;


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

    @FXML
    TextField resultsLimit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handler = new DatabaseHandler();
        Long nrOfQueriesLeft = handler.getNrOfQueriesLeft(HolderCont.userName);
        nrOfQueriesLeftLong = nrOfQueriesLeft;
        resultsLeftLabel.setText(String.valueOf(nrOfQueriesLeft));
    }

    public void searchButtonEvent(ActionEvent e) {
        SearchQuery query = generateQuery();
        Long limit = getLimit();

        if(limit > nrOfQueriesLeftLong) {
            statusDialog.setText("");
            statusDialog.appendText("Not enough search results left on\n your account for this search\n\nPlease contact swtransbuiss@gmail.com to top up your account with more search results\n" +
                    "\nOr lower the search result limit number for this search");
            return;
        }

        if(query == null || limit == -1) {
            statusDialog.setText("");
            statusDialog.appendText("Search failed! Please make sure you have filled in all\nsearch fields correctly and try again");
            return;
        }

        query.setLimit(limit);
        String SqlCommand = query.generateSql();
        ArrayList<InstagramUserRecord> allRecs = generateRecordsBasedOnQuery(SqlCommand);

        updateNrOfResultsLeft(new Long(allRecs.size()));

        System.out.println(query);
    }

    private void updateNrOfResultsLeft(Long limit) {
        Long nrOfQueriesCurr = handler.getNrOfQueriesLeft(HolderCont.userName);
        Long updateQueryNr = nrOfQueriesCurr - limit;
        handler.updateNrOfQueriesLeft(updateQueryNr);
        resultsLeftLabel.setText(String.valueOf(updateQueryNr));
    }

    private Long getLimit() {
        try {
            return Long.parseLong(resultsLimit.getText());
        }catch (Exception e) {
            return -1L;
        }

    }

    private SearchQuery generateQuery() {
        SearchQuery query = new SearchQuery();

        try {
            query.setKeywords(this.keywordsTextField.getText());
            query.setMinNrFollowers(Long.parseLong(this.minNumberOfFollowersTextField.getText()));
            query.setMinNrFollowing(Long.parseLong(this.minNumberOfFollowingTextField.getText()));
            query.setVerifiedAccount(this.verifiedCheckBox.isSelected());
            query.setBusinessAccount(this.isBusinessAccount.isSelected());
            query.setRecentlyJoinedAccount(this.isRecentlyJoined.isSelected());
            query.setBusinessCategory("temp");
            query.setHaveMailAddress(this.isHaveMailAddress.isSelected());

            try {
                query.setFollowingFollowerRatio(Double.parseDouble(this.followingFollowerRatioTextField.getText()));

            }catch (Exception e) {
                String content = this.followingFollowerRatioTextField.getText().replace(",",".");
                query.setFollowingFollowerRatio(Double.parseDouble(content));
                e.printStackTrace();
            }

            return query;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private ArrayList<InstagramUserRecord> generateRecordsBasedOnQuery(String query) {
        statusDialog.setText("");
        statusDialog.appendText("Fetching users....\n");
        ArrayList<InstagramUserRecord> allRecs = handler.getUserRecordsFromQuery(query);
        statusDialog.appendText("Users fetched successfully!\n\nClick on the button below to open up and see your results\n");
        return allRecs;
    }

}
























