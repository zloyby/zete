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
    private static final String INSTRUCTION_TEMPLATE = "=v=> %s =2=> %s ";

    public void startTimerThread() {
        Random r = new Random();
        
        if (BODY_PARTS.length == 0 || COLORS.length == 0) {
            logger.severe("Cannot generate Twister instruction: Color or Body Parts array is empty.");
            return;
        }
        
        int bodyIndex = r.nextInt(BODY_PARTS.length);
        int colorIndex = r.nextInt(COLORS.length);
        
        String instruction = String.format(INSTRUCTION_TEMPLATE, BODY_PARTS[bodyIndex], COLORS[colorIndex]);
        logger.info(instruction);
    }
}