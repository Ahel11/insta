package threads;

import fetchers.UsersFromUserFetcher;
import model.UserToBeFetched;
import threads.helpers.AddUsersToDbThread;

import java.util.ArrayList;

public class AddUsersToDbFromListThread extends Thread {

    public void run() {
        while(true) {
            startAddToDatabaseThread();
            sleepT(UsersFromUserFetcher.addUsersToDbSleepPerRound);
        }

    }

    private void startAddToDatabaseThread() {
        int numberOfUsersForCurrThread = 0;
        int totalNumberAdded = 0;

        ArrayList<UserToBeFetched> currUserList = new ArrayList<>();
        for(int i = 0; i< UsersFromUserFetcher.allUsersToBeFetched.size(); i++) {
            UserToBeFetched currUser = UsersFromUserFetcher.allUsersToBeFetched.get(i);

            if(currUser.isHasBeenAddedToDb()) {
                continue;
            }

            if(totalNumberAdded > UsersFromUserFetcher.numberOfUsersToAddToDbPerRound) {
                return;
            }

            if(numberOfUsersForCurrThread < UsersFromUserFetcher.numberOfUsersPerConnection) {
                currUser.setHasBeenAddedToDb(true);
                currUserList.add(currUser);
                numberOfUsersForCurrThread++;
                totalNumberAdded++;

            } else {
                AddUsersToDbThread currT = new AddUsersToDbThread(currUserList);
                currT.start();
                numberOfUsersForCurrThread = 0;
                currUserList = new ArrayList<>();
            }
        }
    }

    public void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}
