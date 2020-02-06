package instagramimpl;

import database.DatabaseHandler;
import handlers.InstagramScraperHandler;
import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserReelMediaFeedResult;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Core {

    private static int nrOfThreadsAllowed = 28;
    private static ArrayList<String> names = new ArrayList<>();
    public static int nrOfThreads = 0;
    private InstagramScraperHandler instagramHandler = new InstagramScraperHandler();
    private static DatabaseHandler dbHandler = new DatabaseHandler();

    public Core() {
        names.add("jdennisrollins");
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

    public void doIteration(ArrayList<String> randList) {
        for(int i=0; i<randList.size(); i++) {
            String currName = randList.get(i);
            createThread(currName);
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

    private void createThread(String name) {
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






































