package by.zloy.twister;

import java.util.logging.Logger;

import by.zloy.utils.LogWrapper;
import by.zloy.utils.XmlParser;
import by.zloy.utils.Random;

/**
 * The Class TwisterCounter.
 */
public class TwisterCounter {

	/** The logger. */
	private static Logger logger = LogWrapper.getLogger();

	/** The colors. */
	private static final String[] COLORS = { XmlParser.parse("color_red"),
			XmlParser.parse("color_yellow"), XmlParser.parse("color_green"),
			XmlParser.parse("color_blue") };

	/** The body parts. */
	private static final String[] BODY_PARTS = { XmlParser.parse("body_left_hand"),
			XmlParser.parse("body_right_hand"), XmlParser.parse("body_left_leg"),
			XmlParser.parse("body_right_leg") };

	public void startTimerThread() {
		logger.info("=v=> " + BODY_PARTS[Random.getRandom(4)] + " =2=> "
				+ COLORS[Random.getRandom(4)] + " ");
	}

}
