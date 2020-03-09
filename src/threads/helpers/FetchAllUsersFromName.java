package threads.helpers;

import fetchers.UsersFromUserFetcher;
import handlers.InstagramScraperHandler;
import model.UserToBeFetched;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FetchAllUsersFromName extends Thread {

    private String userToFetch = "";

    public FetchAllUsersFromName(String name) {
        userToFetch = name;
    }

    public void run() {
        InstagramScraperHandler instagramHandler = new InstagramScraperHandler();
        ArrayList<String> allPicsFromUser = instagramHandler.getAllPictureIdsFromUser(userToFetch);
        HashSet<String> allUsersRetrived = instagramHandler.getAllUsersFromListOfPics(allPicsFromUser);

        List<UserToBeFetched> allUsers = new ArrayList<>();
        for(String curr: allUsersRetrived) {
            allUsers.add(new UserToBeFetched(curr));
        }

        UsersFromUserFetcher.addUsersToList(allUsers);
    }

}










































