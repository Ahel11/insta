package instagramimpl;

import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;

import java.util.ArrayList;

public class InstagramThread extends Thread{

    private InstagramUser instagramUser;
    private ArrayList<InstagramUserRecord> users;


    public InstagramThread(ArrayList<InstagramUserRecord> users) {
        this.users = users;
    }

    public void run() {
        InstagramHandler handler = new InstagramHandler("astnions93", "Polin137");
        for(InstagramUserRecord s: users) {
            ArrayList<InstagramUserRecord> allRecords = handler.getUserFollowerList(s.getPk());
            Core.addUsers(allRecords);
        }
    }



}


































