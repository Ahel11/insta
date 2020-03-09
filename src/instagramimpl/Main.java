package instagramimpl;

import database.DatabaseHandler;
import database.Test;
import fetchers.AddDbRecordsFetcher;
import fetchers.UsersFromUserFetcher;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;
import selenium.SeleniumHandler;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {

        int choice = 3;

        switch (choice) {
            case 1:
                fetUsersFromUsers();
                break;

            case 2:
                fetchUserRecordsFromNames();
                break;

            case 3:
                sendMailsSelenium();
                break;
        }


        //POPULATE INSTAGRAM RECORDS
        //fetchUserRecordsFromNames();
    }

    public static void sendMailsSelenium() {
        SeleniumHandler handler = new SeleniumHandler();
        handler.sendMails();
    }

    public static void fetUsersFromUsers() {
        UsersFromUserFetcher fromUserFetcher = new UsersFromUserFetcher();
        fromUserFetcher.startGettingUsers();
    }

    public static void fetchUserRecordsFromNames() {
        AddDbRecordsFetcher dbRecordsFetcher = new AddDbRecordsFetcher();
        dbRecordsFetcher.startAddinRecords();
    }

    public static void getUsersOfUsers() {
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> allRecords = handler.getAllRecords();
        ArrayList<InstagramUserRecord> filtered = getFilteredRecords(allRecords);
        Core core;

        for(int i = 425; i<filtered.size(); i++) {
            InstagramUserRecord currRec = filtered.get(i);
            refresh();
            core = new Core(currRec.getName());
            core.start();
            sleepT(5 * 60 * 1000);
        }
    }

    public static void refresh() {
        Core.names = new ArrayList<>();
        Core.nrOfThreads = 0;
        for(Thread t: Core.threads) {
            t.stop();
        }
        Core.threads = new ArrayList<>();
    }

    private static ArrayList<InstagramUserRecord> getFilteredRecords(ArrayList<InstagramUserRecord> allRecords) {
        ArrayList<InstagramUserRecord> filteredRecords = new ArrayList<>();

        for(InstagramUserRecord rec: allRecords) {
            if(rec.getFollowersCount() > 13000) {
                filteredRecords.add(rec);
            }
        }
        return filteredRecords;
    }

    public static void testGetPictureIds() {
        InstagramScraperHandler handler = new InstagramScraperHandler();
        ArrayList<String> allPictureIds = handler.getAllPictureIdsFromUser("thejasmarie");

        String randPictureId = allPictureIds.get(2);
        handler.getUsersFromPictureId(randPictureId);

    }

    public static void testGetInstagramUserRecordFromName() {
        InstagramScraperHandler handler = new InstagramScraperHandler();
        handler.getInstagramUserRecordFromName("thejasmarie");
    }

    public static void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}





























