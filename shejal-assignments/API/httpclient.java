
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

public class httpclient {

    public static void main(String[] args)throws IOException {
        try {
            String result = sendPOST("https://gorest.co.in/public/v2/users");
            System.out.println(result);
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }

    private static String sendPOST(String url) throws IOException {

        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";


        HttpPost post = new HttpPost(url);

        post.addHeader("Accept", "application/json");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb");


        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\":\"shagun\",");
        json.append("\"gender\":\"female\",");
        json.append("\"email\":\"shagun123@gmail.com\",");
        json.append("\"status\":\"active\"");
        json.append("}");


        post.setEntity(new StringEntity(json.toString()));
        CloseableHttpResponse response = httpClient.execute(post);

        result = EntityUtils.toString(response.getEntity());
        return result;

    }

    private static String sendPostUsingConnectionURL(String url){
        return null;
    }

    private static String sendPOSTthroughJson(String url) throws IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String result = "";
        HttpPost post = new HttpPost(url);

        post.addHeader("Accept", "application/json");
        post.addHeader("Content-Type", "application/json");
        post.addHeader("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb");
        return null;

    }
}
