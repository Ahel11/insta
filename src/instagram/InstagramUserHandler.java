package instagram;


import model.MediaIdContainer;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.DefaultBHttpClientConnectionFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Scanner;

//Handles operations for specefic user, such as getting the ID's for the latest pic, list of ID's for recent pics etc
public class InstagramUserHandler {

    private String idFetcherUrl = "https://api.instagram.com/oembed/?url=http://instagram.com/p/";
    private ArrayList<MediaIdContainer> allMediaContainers;
    private HttpClient httpClient;


    public InstagramUserHandler() {
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







    //HELPER FUNCTIONS

    private ArrayList<String> getAllPictureIds(String username) {
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

}






























