package by.zloy.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * The Class PropertiesFinder.
 */
public class PropertiesFinder {

    public static String currentLanguage = null;
    public static URI currentFileUri = null;
    public static int quantity;
    public static int breakTime;
    public static int numMillisecondsToSleep;
    public static boolean isTimer;
    public static boolean isLoggingFile;
    public static boolean isAppend;
    public static String fileName;

    /** The logger. */
	private static Logger logger = LogWrapper.getLogger();

    public static void loadTwisterProperties() {
        Properties properties = new Properties();
        URL url = PropertiesFinder.class.getClassLoader().getResource("twister.properties");
        try {
            properties.load(url.openStream());
        } catch (IOException e) {
            logger.severe(e.getLocalizedMessage());
        }

        currentLanguage = properties.getProperty("LANGUAGE");
        quantity = Integer.valueOf(properties.getProperty("QUANTITY_PEOPLE"));
        breakTime = Integer.valueOf(properties.getProperty("BREAK_TIME"));
        numMillisecondsToSleep = Integer.valueOf(properties.getProperty(
                "NUM_MILLISECONDS_TO_SLEEP"));
        isTimer = Boolean.valueOf(properties.getProperty("IS_TIMER"));
        isLoggingFile = Boolean.valueOf(properties.getProperty("LOG_FILE_USE"));
        isAppend = Boolean.valueOf(properties.getProperty("LOG_FILE_APPEND"));
        fileName = properties.getProperty("LOG_FILE_NAME");

        try {
            currentFileUri = PropertiesFinder.class.getClassLoader().getResource(
                    "languages/" + currentLanguage + ".lang.xml").toURI();
        } catch (URISyntaxException e) {
            logger.severe("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\r\n\r\n!!!!!!!!!!! ");
            logger.severe(e.getLocalizedMessage());
        }
    }
}
