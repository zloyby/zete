package by.zloy.test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author EugenKozlov
 */
public class TestURI {
    private static String url = "rtmp://192.168.195.4:1935/mediacontroller/ddadede3-888b-4ec0-afd1-96256fe9aaa1";

    public static void main(String[] args) throws URISyntaxException {
        URI uri = new URI(url);
        System.out.println(uri.getHost());
    }
}
