package fetchers;

import database.DatabaseHandler;
import model.InstagramUserRecord;
import model.UserToBeFetched;
import org.w3c.dom.CDATASection;
import threads.AddDbRecordsFromListThread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddDbRecordsFetcher {

    public static int nrOfUserrsToAddToDb = 300;
    public static int nrOfRecordsToAddPerRound = 900;
    public static long sleepTimePerRound = 3 * 1000;

    private static int nrOfUsersAddedToDb = 0;

    public static List<InstagramUserRecord> allRecords;

    public static List<UserToBeFetched> allUsersToBeFetched;
    private static DatabaseHandler databaseHandler;

    public AddDbRecordsFetcher() {
        allUsersToBeFetched = new ArrayList<>();
        databaseHandler = new DatabaseHandler();
        allRecords = new ArrayList<>();
    }

    public static synchronized void addAllRecords(InstagramUserRecord currRecord) {
        if(!isValidRecord(currRecord)) {
            return;
        }


        allRecords.add(currRecord);
        if(allRecords.size() > nrOfUserrsToAddToDb) {
            addRecordsToDb();
        }

    }

    private static void printStatus() {
        System.out.println("CurrUsersInBuffer:\t" + allRecords.size() + "\n");
    }

    private static boolean isValidRecord(InstagramUserRecord currRecord) {
        if(currRecord == null) {
            return false;
        }

        if(currRecord.getFollowersCount() < 0 || currRecord.getFollowingCount() < 0) {
            return false;
        }
        return true;
    }

    public void startAddinRecords() {
        initialize();
        startGeneratingRecords();
        System.out.println("Starting generating users");
    }

    public void startGeneratingRecords() {
        AddDbRecordsFromListThread currT = new AddDbRecordsFromListThread();
        currT.start();
    }

    private void initialize() {
        List<String> unFetchedUsers = getUnfetechedUsers(databaseHandler);
        for(String currUser: unFetchedUsers) {
            UserToBeFetched currUserToBeFetched = new UserToBeFetched(currUser);
            allUsersToBeFetched.add(currUserToBeFetched);
        }
    }

    private ArrayList<String> getUnfetechedUsers(DatabaseHandler dbHandler) {
        ArrayList<String> allUsers = dbHandler.getAllUserNames();
        ArrayList<InstagramUserRecord> allRecords = dbHandler.getAllRecords();
        ArrayList<String> allNamesInRecordsDb = getAllNamesFromRecords(allRecords);
        ArrayList<String> allUnfetchedUsers = new ArrayList<>();

        int counter = 0;
        int result = 0;
        Collections.sort(allNamesInRecordsDb);

        for(String currS: allUsers) {
            counter++;
            result = Collections.binarySearch(allNamesInRecordsDb, currS);

            if(result < 0) {
                allUnfetchedUsers.add(currS);
            }
            result = 0;
        }

        return allUnfetchedUsers;
    }

    private ArrayList<String> getAllNamesFromRecords(List<InstagramUserRecord> allRecords) {
        ArrayList<String> allRecordsStr = new ArrayList<>();
        for(InstagramUserRecord rec: allRecords){
            allRecordsStr.add(rec.getName());
        }
        return allRecordsStr;
    }

    private static void addRecordsToDb() {
        nrOfUsersAddedToDb += allRecords.size();
        for(InstagramUserRecord currRecord: allRecords) {
            databaseHandler.addRecord(currRecord);;
        }
        System.out.println("Adding to db complete.. " + nrOfUsersAddedToDb + "\n");
        allRecords = new ArrayList<>();
    }

}




































