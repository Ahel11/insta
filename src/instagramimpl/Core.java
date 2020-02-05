package instagramimpl;

import model.InstagramUserRecord;

import java.util.ArrayList;
import java.util.HashSet;

public class Core {

    private static int nrOfThreadsAllowed = 25;
    private static ArrayList<String> names = new ArrayList<>();
    public static int nrOfThreads = 0;
    private InstagramScraperHandler instagramHandler = new InstagramScraperHandler();

    public Core() {
        names.add("abbyxmakeup");
    }

    public static synchronized void addNames(HashSet<String> users) {
        names.addAll(users);

        HashSet<String> temp = new HashSet<>();
        for(String s: names) {
            temp.add(s);
        }

        System.out.println("\nNameListSize:\t" + temp.size() + "\n");
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
            doIteration();
            if(i==0) {
                sleepT(9000);
            }
        }

    }

    public void doIteration() {
        for(int i=0; i<names.size(); i++) {
            String currName = names.get(i);
            createThread(currName);
        }
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






































