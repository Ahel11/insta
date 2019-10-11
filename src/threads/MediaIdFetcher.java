package threads;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class MediaIdFetcher extends Thread {

    private String mediaIdUrl = "https://api.instagram.com/oembed/?url=http://instagram.com/p/";
    private String username;
    private String pictureId;

    public MediaIdFetcher(String username, String pictureId) {
        this.username = username;
        this.pictureId = pictureId;
    }

    public void run() {
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet getRequest = new HttpGet(mediaIdUrl + pictureId);
            HttpResponse httpResponse = httpClient.execute(getRequest);
            String responseJson = EntityUtils.toString(httpResponse.getEntity());
            JSONObject obj = new JSONObject(responseJson);

            String mediaId = obj.getString("media_id");

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
