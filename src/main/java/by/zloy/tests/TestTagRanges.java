package by.zloy.tests;

import java.util.ArrayList;
import java.util.List;

public class TestTagRanges {

    public static void main(String args[]) {

        final String START_TAG = "<em>";
        final String FINISH_TAG = "</em>";

        //String orig = "abcdefghklmnopr";
        String tagged = "abcem<em>de</em>fghk<em>lmno</em>pr";

        List<String> ranges = new ArrayList<>();

        final Integer[] splitStartEms = getIndexOfTag(tagged, START_TAG, true);
        final Integer[] splitCloseEms = getIndexOfTag(tagged, FINISH_TAG, false);

        for (int i = 0; i < splitStartEms.length; i++) {

            final Integer splitStartEm = splitStartEms[i] - START_TAG.length() * (i + 1) - FINISH_TAG.length() * i;
            final Integer splitCloseEm = splitCloseEms[i] - START_TAG.length() * (i + 1) - FINISH_TAG.length() * i;

            ranges.add(String.join(":", String.valueOf(splitStartEm), String.valueOf(splitCloseEm)));
        }

        System.out.println("ranges : " + ranges);
    }

    private static Integer[] getIndexOfTag(String value, String tag, boolean addTagSize) {
        List<Integer> list = new ArrayList<>();
        for (int i = -1; (i = value.indexOf(tag, i + 1)) != -1; i++) {
            list.add(i + (addTagSize ? tag.length() : 0));
        }
        return list.toArray(new Integer[0]);
    }

}