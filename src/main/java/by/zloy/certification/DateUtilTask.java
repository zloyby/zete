package by.zloy.certification;

import java.text.SimpleDateFormat;
import java.util.Date;

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
}
