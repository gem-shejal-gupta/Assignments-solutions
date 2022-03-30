import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;

public class httpurlconnectionPOST {

    public static void main(String[] args) {
        try {
            String result = sendPostUsingConnectionURL("https://gorest.co.in/public/v2/users");
            System.out.println(result);
        }catch (Exception ex){
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
        json.append("\"name\":\"shail pharma\",");
        json.append("\"gender\":\"male\",");
        json.append("\"email\":\"sp123@gmail.com\",");
        json.append("\"status\":\"active\"");
        json.append("}");


        post.setEntity(new StringEntity(json.toString()));
        CloseableHttpResponse response = httpClient.execute(post);

        result = EntityUtils.toString(response.getEntity());
        return result;

    }

    private static String sendPostUsingConnectionURL(String url){
        String result="";
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection=(HttpURLConnection) url1.openConnection();

            connection.setRequestMethod("POST");


            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Authorization", "Bearer ecef991e9a4d63ac7c9c4e901a97be8331dfa21256e9fbc69d8a5462295932bb");



            connection.setDoOutput(true);

            String inputJson="{\"name\":\"Rahul gupta\", \"gender\":\"male\", \"email\":\"rahulgl12345@gmail.com\", \"status\":\"active\"}";


            try(OutputStream os = connection.getOutputStream()){
                byte[] input = inputJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }


            int code = connection.getResponseCode();
            System.out.println(code);


            try(BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))){
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                result= response.toString();

            }


        }catch(MalformedURLException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        return result;
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