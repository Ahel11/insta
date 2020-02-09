package threads;

import database.DatabaseHandler;
import handlers.InstagramScraperHandler;
import instagramimpl.Core;
import model.InstagramUserRecord;

import java.util.ArrayList;
import java.util.HashSet;

public class InstagramThread extends Thread{

    InstagramScraperHandler instagramHandler;
    private ArrayList<InstagramUserRecord> users;
    private String currName = "";


    public InstagramThread(String name) {
        this.currName = name;
        instagramHandler = new InstagramScraperHandler();
    }

    public void run() {
        ArrayList<String> allPicsFromUser = instagramHandler.getAllPictureIdsFromUser(currName);
        HashSet<String> allUsersRetrived = getAllUsersFromListOfPics(allPicsFromUser);
        //ArrayList<InstagramUserRecord> allRecords = generateInstagramRecords(allUsersRetrived);
        Core.addNames(allUsersRetrived, new DatabaseHandler());
        Core.updateNrOfThreads(-1);

    }

    public ArrayList<InstagramUserRecord> generateInstagramRecords(HashSet<String> names) {
        ArrayList<InstagramUserRecord> allRecords = new ArrayList<>();
        for(String currName: names) {
            InstagramUserRecord rec = instagramHandler.getInstagramUserRecordFromName(currName);
            allRecords.add(rec);
        }
        return allRecords;
    }

    private HashSet<String> getAllUsersFromListOfPics(ArrayList<String> allPics) {
        HashSet<String> allUsers = new HashSet<>();

        for(String currPic: allPics) {
            HashSet<String> currUsers = this.instagramHandler.getUsersFromPictureId(currPic);
            allUsers.addAll(currUsers);
        }
        return allUsers;
    }

    private void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}


































