package database;

import model.InstagramUserRecord;

import javax.xml.crypto.Data;
import java.util.ArrayList;

public class Test {

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

        ArrayList<String> allUsers = new ArrayList<>();
        allUsers.add("kg13133131313aer");
        allUsers.add("dighaadgdgadgagadgag8");
        allUsers.add("dg8adadadgagga13");
        allUsers.add("dahdagga3131314414addaggu");
        handler.addListOfNames(allUsers);
    }

}
