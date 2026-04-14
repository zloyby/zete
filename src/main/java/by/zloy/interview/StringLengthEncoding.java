package by.zloy.interview;

import org.apache.commons.lang3.StringUtils;

/**
 * Write a method that accepts a string and performs a run length encoding on the string.
 * Run length encoding works by looking for long runs of a character in the string and replacing the run with
 * a pair consisting of the number of occurrences in the run, followed by the character itself.
 * For example:
 * "AAABBAAAAABBBCCCCCCCCCAAAAA" -> "3A2B5A3B9C5A"
 */
public class StringLengthEncoding {

    public String runLength(String plain) {
        if (StringUtils.isEmpty(plain)) {
            return StringUtils.EMPTY;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            int runLength = 1;
            while (i+1 < plain.length() &&
                    plain.charAt(i) == plain.charAt(i+1)) {
                runLength++;
                i++;
            }
            builder.append(runLength);
            builder.append(plain.charAt(i));
        }
        return builder.toString();
    }
}
