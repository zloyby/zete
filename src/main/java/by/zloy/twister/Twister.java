/**
 * Twister game
 */
package by.zloy.twister;

import by.zloy.twister.TwisterCounter;
import by.zloy.utils.PropertiesFinder;
import by.zloy.utils.Timer;

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
        PropertiesFinder.loadTwisterProperties();
        TwisterCounter twisterThread = new TwisterCounter();
        Runnable runnable = new Timer(twisterThread, PropertiesFinder.breakTime * PropertiesFinder.quantity);
        Thread thread = new Thread(runnable);
        thread.start();
	}

}
