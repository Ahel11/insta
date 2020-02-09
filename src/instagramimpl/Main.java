package instagramimpl;

import database.DatabaseHandler;
import database.Test;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;

import java.util.ArrayList;

public class Main {

    public static void main(String args[]) {
        //GET INSTAGRAM USERS
        getUsersOfUsers();


        //POPULATE INSTAGRAM RECORDS
        //fetchUserRecordsFromNames();
    }

    public static void fetchUserRecordsFromNames() {
        Core core = new Core("");
        core.fetchUserRecordsFromNames();
    }

    public static void getUsersOfUsers() {
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> allRecords = handler.getAllRecords();
        ArrayList<InstagramUserRecord> filtered = getFilteredRecords(allRecords);
        Core core;

        for(int i = Test.globalBegin; i<filtered.size(); i++) {
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





























