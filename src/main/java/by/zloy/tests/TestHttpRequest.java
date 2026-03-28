package by.zloy.tests;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestHttpRequest {

    public static void main(String[] args) throws IOException {
        System.out.println(new TestHttpRequest().execute());
    }

    private String execute() throws IOException {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String url = "http://www.google.com/search?q=developer";
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request)) {
                System.out.println("\nSending 'GET' request to URL : " + url);
                System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
                HttpEntity responseEntity = response.getEntity();
                BufferedReader rd = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
                StringBuilder result = new StringBuilder();
                String line = "";
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }
                return result.toString();
            }
        }
    }
}
