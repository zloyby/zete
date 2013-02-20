package by.zloy.utils;

public class Random {

	/**
	 * Gets the random number from 0 to n.
	 * 
	 * @param n
	 *            the n
	 * @return the random number
	 */
	public static int getRandom(int n) {
		java.util.Random random = new java.util.Random();
		return random.nextInt(n);
	}
}
