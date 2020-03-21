package by.zloy.apps.twister;

import java.util.Random;
import java.util.logging.Logger;

/**
 * The Class TwisterCounter.
 */
public class TwisterCounter {

    /**
     * The colors.
     */
    private static final String[] COLORS = {XmlParser.parse("color_red"),
            XmlParser.parse("color_yellow"), XmlParser.parse("color_green"),
            XmlParser.parse("color_blue")};
    /**
     * The body parts.
     */
    private static final String[] BODY_PARTS = {XmlParser.parse("body_left_hand"),
            XmlParser.parse("body_right_hand"), XmlParser.parse("body_left_leg"),
            XmlParser.parse("body_right_leg")};
    /**
     * The logger.
     */
    private static Logger logger = LogWrapper.getLogger();

    public void startTimerThread() {
        Random r = new Random();
        int random = r.nextInt(4);
        logger.info("=v=> " + BODY_PARTS[random] + " =2=> " + COLORS[r.nextInt(4)] + " ");
    }

}
