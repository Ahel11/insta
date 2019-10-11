package instagram;

import impl.InstagramOperations;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.brunocvcunha.instagram4j.Instagram4j;
import org.brunocvcunha.instagram4j.requests.*;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedItem;
import org.brunocvcunha.instagram4j.requests.payload.InstagramFeedResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramGetMediaInfoResult;
import org.brunocvcunha.instagram4j.requests.payload.InstagramSearchUsernameResult;

public class InstagramUser implements InstagramOperations {

    private String userName;
    private String pass;
    private Instagram4j instagram4j;

    public InstagramUser(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    @Override
    public void login() {
        try {
            instagram4j = Instagram4j.builder().username(this.userName).password(this.pass).build();
            instagram4j.setup();
            instagram4j.login();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void commentMedia(String mediaId, String comment) {
        try {
            //InstagramFeedResult tagFeed = instagram4j.sendRequest(new InstagramTagFeedRequest("cthagod"));
            long longId = Long.parseLong(mediaId);

            instagram4j.sendRequest(new InstagramPostCommentRequest(longId, comment));
            System.out.print("\n" + this.userName + "\tCommented!\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void likeMedia(String id) {
        try {
            instagram4j.sendRequest(new InstagramLikeRequest(Long.parseLong(id)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void likeComment(String id) {
        try {
            CloseableHttpClient httpClient = instagram4j.getClient();
            HttpPost postReq = new HttpPost("https://www.instagram.com/web/comments/like/" + id);
            postReq.addHeader("path", "/web/comments/like/" + id);
            postReq.addHeader("method", "POST");


            HttpResponse resp = httpClient.execute(postReq);
            String responseStr = EntityUtils.toString(resp.getEntity());


            System.out.print("\n\n\nRespString:\n\n\n" + responseStr);



        } catch (Exception e ){
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












































