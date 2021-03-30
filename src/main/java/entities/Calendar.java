package entities;

import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;
import static java.util.Calendar.DATE;

public class Calendar {

    public static int getDiffYears(Date first, Date last) {
        java.util.Calendar a = getCalendar(first);
        java.util.Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static java.util.Calendar getCalendar(Date date) {
        java.util.Calendar cal = java.util.Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }

    public static String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month-1];
    }
}
