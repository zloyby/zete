package by.zloy.interview;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Which method is correct and why
 */
public class DateUtilTask {

    private static final String SIMPLE_FORMAT = "dd/MM/yyyy";

    SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_FORMAT);

    public String formatDate1(Date input) {
        return sdf.format(input);
    }

    public String formatDate2(Date input) {
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_FORMAT);
        return sdf.format(input);
    }

    public static void main(String[] args) {
        DateUtilTask dateUtilTask = new DateUtilTask();
        System.out.println(dateUtilTask.formatDate1(new Date()));
        System.out.println(dateUtilTask.formatDate2(new Date()));
    }
}
