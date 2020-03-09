package threads;

import fetchers.UsersFromUserFetcher;
import model.UserToBeFetched;
import threads.helpers.FetchAllUsersFromName;

import java.util.ArrayList;
import java.util.List;

public class FetchUsersFromUserFromListThread extends Thread {

    public void run() {
        List<UserToBeFetched> allUsersToBeFetched = new ArrayList<UserToBeFetched>();

        while(true) {
            fetchUserFromList();
            sleepT(UsersFromUserFetcher.fetchUserssleepPerRound);
        }
    }

    private void fetchUserFromList() {
        List<UserToBeFetched> portionUsers = getPortionOfUsers();
        for(UserToBeFetched currUser: portionUsers) {
            FetchAllUsersFromName currFetcher = new FetchAllUsersFromName(currUser.getUsername());
            currFetcher.start();
        }
    }

    private List<UserToBeFetched> getPortionOfUsers() {
        List<UserToBeFetched> portionList = new ArrayList<>();

        for(int i=0; i<UsersFromUserFetcher.allUsersToBeFetched.size(); i++) {
            if(portionList.size() > UsersFromUserFetcher.numberOfUsersToFetchPerRound) {
                return portionList;
            }
            UserToBeFetched currUser = UsersFromUserFetcher.allUsersToBeFetched.get(i);

            if(!currUser.isHasBeenFetched()) {
                currUser.setHasBeenFetched(true);
                portionList.add(currUser);
            }
        }

        return portionList;
    }

    public void sleepT(long ms) {
        try {
          Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}




































