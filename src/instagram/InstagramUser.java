package instagram;

import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetMediaInfoResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

public class InstagramUser {

    private String userName;
    private String pass;
    private Instagram4j instagram4j;

    public InstagramUser(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public void login() {
        try {
            instagram4j = Instagram4j.builder().username(this.userName).password(this.pass).build();
            instagram4j.setup();
            instagram4j.login();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void commentMedia(String mediaId, String comment) {
        try {

            //InstagramFeedResult tagFeed = instagram4j.sendRequest(new InstagramTagFeedRequest("cthagod"));
            long longId = Long.parseLong("2146768961071517401");

            instagram4j.sendRequest(new InstagramPostCommentRequest(longId, "Hello! How are you?"));
            System.out.print("\n\nCommented!!!\n");



            //instagram4j.sendRequest(new InstagramPostCommentRequest(mediaId, "Hello! How are you?"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
