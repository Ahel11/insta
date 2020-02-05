package instagramimpl;

import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

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
        Core.addNames(allUsersRetrived);
        Core.updateNrOfThreads(-1);
    }

    private HashSet<String> getAllUsersFromListOfPics(ArrayList<String> allPics) {
        HashSet<String> allUsers = new HashSet<>();

        for(String currPic: allPics) {
            HashSet<String> currUsers = this.instagramHandler.getUsersFromPictureId(currPic);
            allUsers.addAll(currUsers);
        }
        return allUsers;
    }



}


































