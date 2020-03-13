package fetchers;

import database.DatabaseHandler;
import handlers.InstagramScraperHandler;
import model.UserToBeFetched;
import threads.AddUsersToDbFromListThread;
import threads.FetchUsersFromUserFromListThread;

import java.util.*;

public class UsersFromUserFetcher {

    public static int sizeOfSeedarr = 45000;
    public static int nrOfFollowersMin = 2000;
    public static int numberOfUsersToFetchPerRound = 350;

    public static int numberOfUsersToAddToDbPerRound = 10000;
    public static int numberOfUsersPerConnection = 350;

    public static long fetchUserssleepPerRound = 6 * 1000;
    public static long addUsersToDbSleepPerRound = 5 * 1000;



    public static List<UserToBeFetched> allUsersToBeFetched;
    private DatabaseHandler dbHandler;

    /**
     *  1) Begin with getting a seed, populate the initial array of users from the seed
     *  2) Have a thread that loops through the array and fetches users of users from random users
     *  3) Have a thread that loops through the array and adds a portion of it to the database
     */

    public static synchronized void addUsersToList(List<UserToBeFetched> allUsers) {
        int currSize = allUsersToBeFetched.size();
        if(allUsers.size() == 0) {
            return;
        }

        allUsersToBeFetched.addAll(allUsers);
        allUsersToBeFetched = filterDuplicates();
        System.out.println("Size...\t" + allUsersToBeFetched.size() +  "\n");
    }

    private static void checkIfTooBig(int currSize) {
        //Check if list too big
        if(currSize > 1500000) {
            List<UserToBeFetched> newList = new ArrayList<>();
            for(int i= (1500000/2); i<currSize; i++) {
                newList.add(allUsersToBeFetched.get(i));
            }
            allUsersToBeFetched = new ArrayList<>();
            allUsersToBeFetched = newList;
        }
    }

    public UsersFromUserFetcher() {
       initialize();
    }

    private void initialize() {
        allUsersToBeFetched = new ArrayList<>();
        dbHandler = new DatabaseHandler();
    }

    public void startGettingUsers() {
        intializeWithSeed();
        startFetchUsersFromListThread();
        startAddUsersToDbFromListThread();
        System.out.println("Here");
    }

    private void startAddUsersToDbFromListThread() {
        AddUsersToDbFromListThread currT = new AddUsersToDbFromListThread();
        currT.start();
    }

    private void startFetchUsersFromListThread() {
        FetchUsersFromUserFromListThread fetchUsersFromUserFromListThread = new FetchUsersFromUserFromListThread();
        fetchUsersFromUserFromListThread.start();
    }

    private void intializeWithSeed() {

        List<String> allUsers = dbHandler.getAllUserNames();
        List<UserToBeFetched> seedArr = new ArrayList<>();
        for(int i=0; i<sizeOfSeedarr; i++) {
            int randNr = getRandNrFromList(allUsers);
            UserToBeFetched curr = new UserToBeFetched(allUsers.get(randNr));
            curr.setHasBeenAddedToDb(true);
            seedArr.add(curr);
        }
        UsersFromUserFetcher.addUsersToList(seedArr);

    }

    private int getRandNrFromList(List<String> list) {
        Random r = new Random();
        int randNr = r.nextInt()%list.size();
        if(randNr < 0) {
            randNr *= -1;
        }
        return randNr;
    }

    private List<UserToBeFetched> fetchUsersFromUser(String username) {
        InstagramScraperHandler instagramHandler = new InstagramScraperHandler();
        ArrayList<String> allPicsFromUser = instagramHandler.getAllPictureIdsFromUser(username);
        HashSet<String> allUsersRetrived = instagramHandler.getAllUsersFromListOfPics(allPicsFromUser);

        List<UserToBeFetched> allUsers = new ArrayList<>();
        for(String currUser: allUsersRetrived) {
            UserToBeFetched currUserToBeFetched = new UserToBeFetched(currUser);
            allUsers.add(currUserToBeFetched);
        }

        return allUsers;
    }

    private static List<UserToBeFetched> filterDuplicates() {
        HashSet<UserToBeFetched> allUsers = new HashSet<>();
        allUsers.addAll(allUsersToBeFetched);
        allUsersToBeFetched = new ArrayList<>();
        for(UserToBeFetched curr: allUsers) {
            allUsersToBeFetched.add(curr);
        }
        return allUsersToBeFetched;
    }

}






























