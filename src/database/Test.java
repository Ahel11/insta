package database;

import instagramimpl.MainHandl;
import model.CometonAccount;
import model.InstagramUserRecord;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static int globalBegin = 120;

    public static void main(String args[]) {
        getMails();
        //runeer();
    }

    public static void getMails() {
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> records = handler.getAllRecords();

        ArrayList<String> allMails = new ArrayList<>();

        for(InstagramUserRecord rec: records) {
            String currMail = getMailFromBio(rec.getBio());
            if(currMail != null) {
                System.out.println(currMail);
            }
        }

    }

    private static String getMailFromBio(String bio) {
        Scanner scanner = new Scanner(bio);

        String currToken = "";
        while(scanner.hasNext()) {
            currToken = scanner.next();
            if( currToken.contains("gmail") || currToken.contains("yahoo") || currToken.contains("outlook")) {
                currToken = currToken.replace(String.valueOf('"'), "");
                currToken = currToken.replace(String.valueOf(']'), "");
                currToken = currToken.replace(String.valueOf('|'), "");
                if(currToken.contains(":")) {
                    return currToken.split(":")[1];
                }
                return currToken;
            }
        }
        return null;
    }

    public static void runeer() {
        while(true) {
            MainHandl handl = new MainHandl();
            handl.start();
            sleepT(95000);
            handl.stop();
            globalBegin++;
        }
    }

    public static void databaseTesting() {
        DatabaseHandler handler = new DatabaseHandler();
        CometonAccount account = handler.getCometonAccount("jimbo", "123456");
    }

    public static void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}











































