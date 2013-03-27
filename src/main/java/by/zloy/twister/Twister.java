/**
 * Twister game
 */
package by.zloy.twister;

import by.zloy.utils.Timer;
import by.zloy.utils.TwisterPropertiesFinder;

/**
 * The Class Twister.
 */
public class Twister {

    /**
     * Main function of twister.
     *
     * @param args command-arguments
     */
    public static void main(final String[] args) {
        TwisterPropertiesFinder.loadTwisterProperties();
        TwisterCounter twisterThread = new TwisterCounter();
        Runnable runnable = new Timer(twisterThread, TwisterPropertiesFinder.breakTime * TwisterPropertiesFinder.quantity);
        Thread thread = new Thread(runnable);
        thread.start();
    }

}
