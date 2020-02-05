package instagramimpl;

import handlers.AccountConverterHandler;
import model.InstagramUserRecord;
import model.MediaIdContainer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class InstagramScraperHandler {

    private String idFetcherUrl = "https://api.instagram.com/oembed/?url=http://instagram.com/p/";
    private ArrayList<MediaIdContainer> allMediaContainers;
    private HttpClient httpClient;


    public InstagramScraperHandler() {
        httpClient = HttpClientBuilder.create().build();
        allMediaContainers = new ArrayList<>();
    }


    //PRIMARY FUNCTIONS

    //Retrieves the lastest mediaIds from the user
    public ArrayList<String> getAllPictureIdsFromUser(String user) {

        ArrayList<String> allMediaIds = new ArrayList<>();
        allMediaIds = getAllPictureIds(user);

        return allMediaIds;
    }

    //From a given pictureId, retrieves the corresponding mediaId
    public String getMediaIdFromPictureId(String pictureId) {
        pictureId = pictureId.replace(String.valueOf('"'), "");
        try {
            String mediaIdFetcherUrl = idFetcherUrl + pictureId;
            HttpGet get = new HttpGet(mediaIdFetcherUrl);
            HttpResponse httpResponse = httpClient.execute(get);
            String responseStr = EntityUtils.toString(httpResponse.getEntity());
            JSONObject responseJsonObj = new JSONObject(responseStr);

            String mediaId = responseJsonObj.getString("media_id");
            return mediaId.split("_")[0];

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    public HashSet<String> getUsersFromPictureId(String pictureId) {
        HashSet<String> allUsersFound = new HashSet<>();
        try {
            HttpGet get = new HttpGet("https://www.instagram.com/p/" + pictureId);
            HttpResponse httpResponse = httpClient.execute(get);
            String responseStr = EntityUtils.toString(httpResponse.getEntity());
            String splitted[] = responseStr.split("username");

            for(String currToken: splitted) {
                String extractedUsername = extractUserNameFromScannerToken(currToken);
                if(isUsernameLegitimate(extractedUsername)) {
                    allUsersFound.add(extractedUsername);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return allUsersFound;
    }

    public InstagramUserRecord getInstagramUserRecordFromName(String userName) {
        InstagramUserRecord recordToReturn = new InstagramUserRecord();
        AccountConverterHandler converterHandler = new AccountConverterHandler();

        try {
            HttpGet get = new HttpGet("https://www.instagram.com/" + userName);
            HttpResponse httpResponse = httpClient.execute(get);
            String responseStr = EntityUtils.toString(httpResponse.getEntity());
            recordToReturn = converterHandler.convertHtmlToInstagramUserRecord(responseStr);

            System.out.println(recordToReturn + "\n");

        }catch (Exception e) {
            e.printStackTrace();
        }

        return recordToReturn;
    }




    //HELPER FUNCTIONS

    private String extractUserNameFromScannerToken(String token) {
        String clean = null;
        try {
            Scanner scanner = new Scanner(token);
            scanner.useDelimiter(",");
            String curr = scanner.next();

            clean = curr.split(":")[1].replace(String.valueOf('"'),"");
            clean = clean.replace("}", "");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return clean;
    }

    public ArrayList<String> getAllPictureIds(String username) {
        ArrayList<String> allPictureIds = new ArrayList<>();

        try {
            HttpGet get = new HttpGet("https://www.instagram.com/" + username);
            HttpResponse httpResponse = httpClient.execute(get);

            String responseStr = EntityUtils.toString(httpResponse.getEntity());
            allPictureIds = getAllPictureIdsFromResponse(responseStr);

        }catch (Exception e) {
            e.printStackTrace();
        }
        return allPictureIds;
    }

    public ArrayList<String> getAllPictureIdsFromResponse(String httpResponseStr) {
        ArrayList<String> allShortCodes = new ArrayList<>();
        for(String s: httpResponseStr.split("shortcode")) {
            try {
                String currShortCode = s.split(",")[0].split(":")[1];
                currShortCode = currShortCode.replace(String.valueOf('"'), "");
                allShortCodes.add(currShortCode);
            }catch (Exception e) {
                continue;
            }
        }
        return allShortCodes;
    }

    private boolean isUsernameLegitimate(String name) {
        if(name == null || name.contains(" ")) {
            return false;
        }
        return true;
    }

}
