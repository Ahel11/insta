package instagramimpl;

import model.InstagramUserRecord;

import java.util.ArrayList;

public class Core {

    private static ArrayList<InstagramUserRecord> allUsers = new ArrayList<>();

    public static synchronized void addUsers(ArrayList<InstagramUserRecord> users) {
        allUsers.addAll(users);
        printAllUsers();
    }

    public static synchronized void printAllUsers() {
        System.out.println("\n\n\n\n\n\n");
        for(InstagramUserRecord s: allUsers) {
            System.out.println(s + "\n");
        }
        System.out.println("Size:\t" + allUsers.size() + "\n\n\n");
    }

}






































