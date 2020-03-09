package threads;

import fetchers.AddDbRecordsFetcher;
import model.UserToBeFetched;
import threads.helpers.GenerateRecordFromNameThread;

import java.util.ArrayList;
import java.util.List;

public class AddDbRecordsFromListThread extends Thread {

    public void run() {
        while(true) {
            fetchUsersToGenerateRecords();
            sleepT(AddDbRecordsFetcher.sleepTimePerRound);
        }
    }

    public void fetchUsersToGenerateRecords() {
        List<UserToBeFetched> allUsers = getPortionOfUsers();
        for(UserToBeFetched currUser: allUsers) {
            GenerateRecordFromNameThread currGenerator = new GenerateRecordFromNameThread(currUser.getUsername());
            currGenerator.start();
        }
    }

    private List<UserToBeFetched> getPortionOfUsers() {
        List<UserToBeFetched> usersToReturn = new ArrayList<>();

        for(int i=0; i<AddDbRecordsFetcher.allUsersToBeFetched.size(); i++) {
            UserToBeFetched currUser = AddDbRecordsFetcher.allUsersToBeFetched.get(i);

            //Check if the currUser has been fetched
            if(currUser.isHasBeenFetched()) {
                continue;
            }

            currUser.setHasBeenFetched(true);
            usersToReturn.add(currUser);
            if(usersToReturn.size() > AddDbRecordsFetcher.nrOfRecordsToAddPerRound) {
                return usersToReturn;
            }
        }
        return usersToReturn;
    }

    public void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}
