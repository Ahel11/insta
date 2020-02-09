package database;

import instagramimpl.MainHandl;
import model.CometonAccount;
import model.InstagramUserRecord;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Test {

    public static int globalBegin = 95;

    public static void main(String args[]) {
        DatabaseHandler handler = new DatabaseHandler();
        /*InstagramUserRecord rec = new InstagramUserRecord();
        rec.setName("adg");
        rec.setBio("aigd");
        rec.setFollowingCount(13994);
        rec.setMediaCount(1123);
        rec.setFollowersCount(134);
        rec.setPk(134);
        rec.setPhoneNumber("194");
        rec.setBusinessCategoryName("business");
        rec.setBusinessAccount(false);
        rec.setVerfied(false);
        rec.setExternalUrl("aodgadgou.com");
        rec.setMail("@gadouga.com");
        rec.setNrOfHighlights(new Long(0));
*/
        //runeer();
        databaseTesting();
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
