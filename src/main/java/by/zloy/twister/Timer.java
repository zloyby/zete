/**
 * Timer class
 */
package by.zloy.twister;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * The Class Timer.
 *
 * @author e.kozlov
 */
public class Timer implements Runnable {

    /**
     * The logger.
     */
    private static Logger logger = LogWrapper.getLogger();

    /**
     * The object.
     */
    private TwisterCounter object = null;

    /**
     * The time2run.
     */
    private int time2run;

    private Timer() {
    }

    /**
     * Constructor.
     *
     * @param object   TwisterCounter the object
     * @param time2run the time2run
     */
    public Timer(TwisterCounter object, int time2run) {
        this.object = object;
        this.time2run = time2run;
    }

    /**
     * Run thread.
     *
     * @see java.lang.Runnable#run()
     */
    public void run() {
        int runningCount = 1;
        while (true) {
            if (runningCount > time2run) {
                return;
            }
            object.startTimerThread();
            if (TwisterPropertiesFinder.isTimer) {
                try {
                    Thread.sleep(TwisterPropertiesFinder.numMillisecondsToSleep);
                } catch (InterruptedException e) {
                    logger.severe(e.getLocalizedMessage());
                }
            } else {
                try {
                    System.in.read();
                } catch (IOException e) {
                    logger.severe(e.getLocalizedMessage());
                }
            }
            runningCount++;
        }
    }
}
