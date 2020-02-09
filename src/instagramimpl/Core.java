package instagramimpl;

import database.DatabaseHandler;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;
import threads.FetchUserFromNameThread;
import threads.InstagramThread;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Core extends Thread{

    private static int nrOfThreadsAllowed = 85;
    public static ArrayList<String> names = new ArrayList<>();
    public static ArrayList<Thread> threads = new ArrayList<>();
    public static int nrOfThreads = 0;
    private InstagramScraperHandler instagramHandler = new InstagramScraperHandler();
    private static DatabaseHandler dbHandler = new DatabaseHandler();

    //siemprebuen
    public Core(String seed) {
        names.add(seed);
    }

    public void run() {
        getUsersOfUsers();
    }

    public static void addNames(HashSet<String> users, DatabaseHandler dbHandlerInserted) {
        names.addAll(users);

        HashSet<String> temp = new HashSet<>();
        for(String s: names) {
            temp.add(s);
        }

        for(String s: temp) {
            dbHandlerInserted.addUserName(s);
        }

        System.out.println("\nNameListSize:\t" + temp.size() + "\n");
    }

    public static synchronized void addRecords(ArrayList<InstagramUserRecord> allRecords) {
        for(InstagramUserRecord rec: allRecords) {
            dbHandler.addRecord(rec);
        }
        System.out.println("Added to db....\n");
    }

    public static synchronized void updateNrOfThreads(int nr) {
        nrOfThreads = nrOfThreads + (nr);
        if(nrOfThreads < 0)nrOfThreads=0;
        System.out.println("\nNumberOfThreads..\t" + nrOfThreads);
    }


    /**
     * 1) Given a seed, do 5 iterations of getting users of users
     */
    public void getUsersOfUsers() {

        for(int i=0; i<100; i++) {
            if(i==0) {
                doIteration(names);
                sleepT(20000);
            }
            doIteration(randNames());
        }
    }

    public void fetchUserRecordsFromNames() {
        int nrOfThreads = 50;
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<String> allNames = getUnfetechedUsers(handler);

        int nrOfUsersPerThread = allNames.size() / nrOfThreads;
        ArrayList<String> tempNames = new ArrayList<>();
        int counter = 0;

        for(int i=0; i<allNames.size(); i++) {
            if(counter <= nrOfUsersPerThread) {
                tempNames.add(allNames.get(i));
            } else {
                FetchUserFromNameThread t = new FetchUserFromNameThread(tempNames);
                t.start();
                System.out.println("Starting t:\t" + i + "\n");

                tempNames = new ArrayList<>();
                counter = 0;
            }
            counter++;
        }

    }

    private ArrayList<String> getUnfetechedUsers(DatabaseHandler dbHandler) {
        ArrayList<String> allUsers = dbHandler.getAllUserNames();
        ArrayList<InstagramUserRecord> allRecords = dbHandler.getAllRecords();
        ArrayList<String> allUnfetchedUsers = new ArrayList<>();
        int counter = 0;

        for(String currS: allUsers) {
            counter++;
            if(!isNameInListOfRecords(currS, allRecords)) {
                allUnfetchedUsers.add(currS);
            }
        }

        return allUnfetchedUsers;
    }

    private boolean isNameInListOfRecords(String name, ArrayList<InstagramUserRecord> records) {
        for(InstagramUserRecord rec: records) {
            if(rec.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void doIteration(ArrayList<String> randList) {
        for(int i=0; i<randList.size(); i++) {
            String currName = randList.get(i);
            threads.add(createThread(currName));
        }
    }

    private ArrayList<String> randNames() {
        ArrayList<String> rand = new ArrayList<>();
        for(int i=0; i<100; i++) {
            Random r = new Random();
            int randNr = r.nextInt()%names.size();
            if(randNr<0)randNr*=-1;
            rand.add(names.get(randNr));
        }
        return rand;
    }

    private Thread createThread(String name) {
        while(true) {
            if(nrOfThreads >= nrOfThreadsAllowed) {
                sleepT(2000);
            } else {
                break;
            }
        }

        InstagramThread currT = new InstagramThread(name);
        currT.start();
        updateNrOfThreads(1);
        return currT;
    }

    private static void removeDuplicates() {
        HashSet<String> allStrings = new HashSet<>();
        for(String currName: names) {
            allStrings.add(currName);
        }
        names = new ArrayList<>();
        names.addAll(allStrings);
    }

    public void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}






































