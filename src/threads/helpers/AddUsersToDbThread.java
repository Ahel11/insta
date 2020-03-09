package threads.helpers;

import database.DatabaseHandler;
import model.UserToBeFetched;

import java.util.ArrayList;
import java.util.List;

public class AddUsersToDbThread extends Thread {

    private DatabaseHandler handler = new DatabaseHandler();
    private List<UserToBeFetched> usersToAdd = new ArrayList<>();

    public AddUsersToDbThread(List<UserToBeFetched> allUsers){
        usersToAdd = allUsers;
    }

    public void run() {
        for(UserToBeFetched currUser: usersToAdd) {
            handler.addUserName(currUser.getUsername());
        }
    }

}



































