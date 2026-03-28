package by.zloy.utils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

/**
 * @author eugenkozlov
 */
public class PropertiesUtil {

    public static Properties loadProperties(String resource) throws IOException {
        Properties properties = new Properties();
        URL url = ClassLoader.getSystemResource(resource);
        properties.load(url.openStream());
        return properties;
    }

    public static File loadCsv(String resource) throws IOException {
        URL url = ClassLoader.getSystemResource(resource);
        return new File(url.getFile());
    }
}
