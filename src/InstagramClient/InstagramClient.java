package InstagramClient;

import database.DatabaseHandler;
import helpers.HttpHelper;
import helpers.LogHandler;
import helpers.MailTextGenerator;
import me.postaddict.instagram.scraper.request.GetMediasRequest;
import model.InstagramUserRecord;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InstagramClient extends Thread{

    private String idFetcherUrl = "https://api.instagram.com/oembed/?url=http://instagram.com/p/";
    private String username;
    private String password;
    private boolean loggedInSuccess = false;
    private Instagram4j instagram4j;

    private HttpHelper helper;

    public InstagramClient(String username, String pass) {

        this.username = username;
        this.password = pass;
        initialize();
    }

    private void initialize() {
        helper = new HttpHelper();
        this.loggedInSuccess = this.loginAcc();
        return;
    }

    public boolean loginAcc() {
        boolean result = false;
        try {
            instagram4j = Instagram4j.builder().username(this.username).password(this.password).build();
            instagram4j.setup();
            InstagramLoginResult res = instagram4j.login();
            return res.getStatus().equalsIgnoreCase("ok");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void run() {
        if(!loggedInSuccess) return;

        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> allAccs = handler.getAllRecords();

        while(true) {
            String currUsername = getRandomUsername(InstagramClientHandler.allUsernames);
            InstagramPostCommentResult currResult = commentUserPic(currUsername);
            String logEvent = LogHandler.generateCommentLogEvent(currResult, this.username);
            InstagramClientHandler.addEventLog(logEvent);
            sleepT(35 * 000);
        }
    }

    //CORE FUNCTIONS
    public InstagramGetCurrentUserProfileResult updateProfile() {
        InstagramGetCurrentUserProfileResult profileResult = null;

        InstagramEditProfileRequest profileRequest = InstagramEditProfileRequest.builder()
                .username(this.username)
                .website("http://igfollowmasters.com/")
                .email("adgag3114@gmail.com")
                .phone("+46704895874")
                .fullName(this.username)
                .gender(InstagramUserGenderEnum.MALE)
                .biography("Check us out below for the best way to grow and promote your Instagram account!").build();

        try {
            profileResult = this.instagram4j.sendRequest(profileRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profileResult;
    }

    private String getRandomUsername(ArrayList<String> allNames) {
        Random r = new Random();
        int randIndex = 0;
        randIndex = r.nextInt()%allNames.size();
        if(randIndex<0)randIndex *= -1;
        return allNames.get(randIndex);
    }

    public InstagramPostCommentResult commentUserPic(String username) {
        InstagramPostCommentResult result = null;
        ArrayList<String> allMediaIds = getAllPictureIds(username);
        if(allMediaIds == null || allMediaIds.size() == 0) {
            return result;
        }

        Long mediaIdToUse = Long.parseLong(getMediaIdFromPictureId(allMediaIds.get(0)));

        InstagramPostCommentRequest commentRequest = new InstagramPostCommentRequest(mediaIdToUse,MailTextGenerator.generateMailText());
        try {
            result = instagram4j.sendRequest(commentRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public StatusResult sendMessage(String name) {
        StatusResult sendMessageStatus = null;

        try {
            String id = getIdFromName(name);
            ArrayList<String> idsToSend = new ArrayList<>();
            idsToSend.add(id);

            InstagramDirectShareRequest shareRequest = InstagramDirectShareRequest.builder()
                    .shareType(InstagramDirectShareRequest.ShareType.MESSAGE)
                    .recipients(idsToSend)
                    .message(MailTextGenerator.generateMailText())
                    .build();

            sendMessageStatus = this.instagram4j.sendRequest(shareRequest);
            return sendMessageStatus;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendMessageStatus;
    }

    public List<InstagramInboxThread> getInbox() {
        try {
            InstagramGetInboxRequest request = new InstagramGetInboxRequest();
            InstagramInboxResult res = this.instagram4j.sendRequest(request);
            InstagramInbox inbox = res.getInbox();

            List<InstagramInboxThread> allMessages = inbox.getThreads();
            return allMessages;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }






    public String getMediaIdFromPictureId(String pictureId) {
        pictureId = pictureId.replace(String.valueOf('"'), "");
        try {
            String mediaIdFetcherUrl = idFetcherUrl + pictureId;
            String responseStr = helper.executeGetReq(mediaIdFetcherUrl);
            JSONObject responseJsonObj = new JSONObject(responseStr);

            String mediaId = responseJsonObj.getString("media_id");
            return mediaId.split("_")[0];

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    private InstagramUser getInstagramUser(String name) {
        String userNameId = this.helper.executeGetReq("https://www.instagram.com/" + username + "/?__a=1");
        userNameId = userNameId.split("profilePage_")[1].split(",")[0].replace(String.valueOf('"'), "");
        InstagramSearchUsernameResult res = null;

        InstagramGetUserInfoRequest userInfo = new InstagramGetUserInfoRequest(Long.parseLong(userNameId));
        try {
            res = instagram4j.sendRequest(userInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (res==null)return null;
        return res.getUser();
    }

    private ArrayList<String> getAllPictureIds(String username) {
        ArrayList<String> allPictureIds = new ArrayList<>();

        try {
            String responseStr = helper.executeGetReq("https://www.instagram.com/" + username);
            allPictureIds = getAllPictureIdsFromResponse(responseStr);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return allPictureIds;
    }

    private ArrayList<String> getAllPictureIdsFromResponse(String httpResponseStr) {
        ArrayList<String> allShortCodes = new ArrayList<>();
        for(String s: httpResponseStr.split("shortcode")) {
            try {
                String currShortCode = s.split(",")[0].split(":")[1];
                allShortCodes.add(currShortCode);
            }catch (Exception e) {
                continue;
            }
        }
        return allShortCodes;
    }

    private String getIdFromName(String name) {
        InstagramSearchUsernameResult userResult = null;
        try {
            userResult = instagram4j.sendRequest(new InstagramSearchUsernameRequest(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(userResult == null) {
            return null;
        }
        return String.valueOf(userResult.getUser().getPk());
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instagram4j getInstagram4j() {
        return instagram4j;
    }

    public void setInstagram4j(Instagram4j instagram4j) {
        this.instagram4j = instagram4j;
    }

    private void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



































