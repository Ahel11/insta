package helpers;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Random;

public class HttpHelper {

    HttpClient httpClient;

    public HttpHelper() {
        httpClient = HttpClientBuilder.create().build();
    }

    public String executeGetReq(String url) {
        String resp = null;
        try {
            HttpGet get = new HttpGet(url);
            get.setHeader(HttpHeaders.USER_AGENT, randomizeUserAgent());
            HttpResponse httpResponse = httpClient.execute(get);
            resp = EntityUtils.toString(httpResponse.getEntity());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }

    private String randomizeUserAgent() {
        ArrayList<String> allAgents = new ArrayList<>();
        allAgents.add("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.135 Safari/537.36 Edge/12.246");
        allAgents.add("Mozilla/5.0 (X11; CrOS x86_64 8172.45.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.64 Safari/537.36");
        allAgents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_2) AppleWebKit/601.3.9 (KHTML, like Gecko) Version/9.0.2 Safari/601.3.9");
        allAgents.add("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20120121 Firefox/46.0");
        allAgents.add("Mozilla/5.0 (Windows NT 10.0; WOW64; rv:45.66.18) Gecko/20177177 Firefox/45.66.18");
        allAgents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10; rv:33.0) Gecko/20100101 Firefox/33.0");
        allAgents.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.47 Safari/537.36");
        allAgents.add("Mozilla/5.0 (Windows NT 5.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/34.0.1866.237 Safari/537.36");
        allAgents.add("Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1468.0 Safari/537.36");

        allAgents.add("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:15.0) Gecko/20100101 Firefox/15.0.1");

        Random r = new Random();
        int randNr = r.nextInt()%allAgents.size();
        if(randNr<0)randNr*=-1;
        return allAgents.get(randNr);


    }


}
