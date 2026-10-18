package by.zloy.apps.twister;

import java.util.logging.Logger;

/**
 * Twister game
 */
public class Twister {

    private static final Logger logger = LogWrapper.getLogger();

    /**
     * Main function of twister.
     *
     * @param args command-arguments
     */
    public static void main(final String[] args) {
        try {
            // 1. Load necessary configuration properties
            TwisterPropertiesFinder.loadTwisterProperties();
            logger.info("Twister properties loaded successfully.");

            // 2. Initialize game components
            TwisterCounter counter = new TwisterCounter();
            
            // Calculate the total quantity of turns based on properties
            int totalTurns = TwisterPropertiesFinder.breakTime * TwisterPropertiesFinder.quantity;
            
            // 3. Set up and start the game timer thread
            Runnable gameRunner = new Timer(counter, totalTurns);
            Thread thread = new Thread(gameRunner, "TwisterGameThread");
            thread.start();
            logger.info("Twister game initiated and running.");

        } catch (Exception e) {
            logger.severe("Fatal error during Twister game initialization: " + e.getMessage());
        }
    }

}