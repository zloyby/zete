package by.zloy.utils;

import java.io.IOException;
import java.util.logging.FileHandler;

/**
 * The Class LogWrapper.
 */
public class LogWrapper {

    /**
     * The logger.
     */
    private static java.util.logging.Logger logger = null;

    /**
     * The handler.
     */
    private static FileHandler handler = null;

    /**
     * The empty Constructor.
     */
    private LogWrapper() {
    }

    /**
     * Adds the file logging.
     *
     * @return the file handler
     */
    private static FileHandler addFileLogging() {
        if (handler == null) {
            try {
                handler = new FileHandler(System.getProperty("user.dir") +
                        "\\" +
                        TwisterPropertiesFinder.fileName,
                        TwisterPropertiesFinder.isAppend);
                logger.addHandler(handler);
            } catch (IOException e) {
                logger.severe(e.getLocalizedMessage());
                return null;
            }
        }
        return handler;
    }

    /**
     * Gets the logger.
     *
     * @return the logger
     */
    public static java.util.logging.Logger getLogger() {
        logger = java.util.logging.Logger.getLogger("by.zloy");
        if (TwisterPropertiesFinder.isLoggingFile) {
            addFileLogging();
        }
        return logger;
    }
}
