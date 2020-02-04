package instagramimpl;


import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.InstagramGetUserFollowersRequest;
import org.brunocvcunha.instagram4j.requests.InstagramSearchUsernameRequest;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetUserFollowersResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUser;
import org.brunocvcunha.instagram4j.requests.payload.InstagramUserSummary;

import java.util.ArrayList;
import java.util.List;

public class InstagramHandler {

    private String username;
    private String pass;
    private Instagram4j instagram;

    public InstagramHandler(String username, String password) {
        this.username = username;
        this.pass = password;
        login();
    }

    private void login() {
        try {
            instagram = Instagram4j.builder().username(this.username).password(this.pass).build();
            instagram.setup();
            instagram.login();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InstagramUserRecord fetchUser(String userId) {
        try {
            InstagramSearchUsernameResult userResult = instagram.sendRequest(new InstagramSearchUsernameRequest(userId));
            userResult.getUser().getPublic_phone_number();
            return convertToInstaUser(userResult.getUser());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<InstagramUserRecord> getUserFollowerList(long pk) {
        ArrayList<InstagramUserRecord> followerList = new ArrayList<>();
        try {
            InstagramGetUserFollowersResult followers = instagram.sendRequest(new InstagramGetUserFollowersRequest(pk));
            List<InstagramUserSummary> users = followers.getUsers();

            for(InstagramUserSummary sum: users) {
                InstagramUserRecord rec = new InstagramUserRecord();
                rec.setPk(sum.getPk());
                rec.setName(sum.getUsername());
                followerList.add(rec);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return followerList;
    }

    private InstagramUserRecord convertToInstaUser(InstagramUser u) {
        InstagramUserRecord rec = new InstagramUserRecord();
        rec.setName(u.getUsername());
        rec.setBio(u.getBiography());
        rec.setFollowersCount(u.getFollower_count());
        rec.setFollowingCount(u.getFollowing_count());
        rec.setPhoneNumber(u.getPublic_phone_number());
        rec.setMediaCount(u.getMedia_count());
        rec.setPk(u.getPk());

        return rec;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
