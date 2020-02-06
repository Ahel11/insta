package helpers;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpHelper {

    HttpClient httpClient;

    public HttpHelper() {
        httpClient = HttpClientBuilder.create().build();
    }

    public String executeGetReq(String url) {
        String resp = null;
        try {
            HttpGet get = new HttpGet(url);
            HttpResponse httpResponse = httpClient.execute(get);
            resp = EntityUtils.toString(httpResponse.getEntity());
        }catch (Exception e) {
            e.printStackTrace();
        }
        return resp;
    }


}
