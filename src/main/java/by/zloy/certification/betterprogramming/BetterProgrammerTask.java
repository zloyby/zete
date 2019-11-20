package by.zloy.certification.betterprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author EugenKozlov
 */

public class BetterProgrammerTask {

    public static int getLargestRootToLeafSum(Node root) {
        /*
          A root-to-leaf path in a tree is a path from a leaf node through all its ancestors
          to the root node inclusively.
          A "root-to-leaf sum" is a sum of the node values in a root-to-leaf path.

          Please implement this method to
          return the largest root-to-leaf sum in the tree.
         */
        return 0;
    }

    public static int getRequiredNumberOfBits(int N) {
        /*
          Please implement this method to
          return the number of bits which is just enough to store any integer from 0 to N-1 inclusively
          for any int N > 0
          Example: to store 5 integers from 0 to 4 you need 3 bits: 000, 001, 010, 011, 100 and 101
        */
        return Integer.toBinaryString(N).length();
    }

    public static Object[] reverseArray(Object[] a) {
        /*
          Please implement this method to
          return a new array where the order of elements has been reversed from the original
          array.
         */
        List<Object> list = Arrays.asList(a);
        Collections.reverse(list);
        return list.toArray();
    }

    public static int getSumOfNumbers(String s) {
        /*
          Please implement this method to
          return the sum of all integers found in the parameter String. You can assume that
          integers are separated from other parts with one or more spaces (' ' symbol).
          For example, s="12 some text 3  7", result: 22 (12+3+7=22)
         */
        int result = 0;

        String decimalPattern = "(\\d{1,3})?(.)?(\\d{1,3})?";
        String integerPattern = "(\\d{1,3})";

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();

            if (token.contains(".")) {
                if (token.matches(decimalPattern)) {
                    result += Double.parseDouble(token);
                }
            } else {
                if (token.matches(integerPattern)) {
                    result += Integer.parseInt(token);
                }
            }
        }
        return result;
    }

    public static String reverseWords(String s) {
        /*
          Assume that the parameter String can only contain spaces and alphanumeric characters.
          Please implement this method to
          reverse each word in the original String while maintaining the word order.
          For example:
          parameter: "Hello world", result: "olleH dlrow"
         */
        StringBuffer result = new StringBuffer();
        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String reverseToken = reverse(st.nextToken());
            result.append(reverseToken).append(" ");
        }
        return result.toString();
    }

    public static String reverse(String arg) {
        String tmp = null;
        if (arg.length() == 1) {
            return arg;
        } else {
            //extract the last char
            String lastChar = arg.substring(arg.length() - 1, arg.length());
            //extract the remaining chars
            String remainingString = arg.substring(0, arg.length() - 1);
            tmp = lastChar + reverse(remainingString);
            return tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(getRequiredNumberOfBits(5));
    }

    // Please do not change this interface
    public static interface Node {
        int getValue();

        List<Node> getChildren();
    }

}
