package app.utils;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@UtilityClass
public class LocalDateFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/LLLL/yyyy");


    public static String getFormattedDate(LocalDate date) {
        return formatter.format(date);
    }

//    public static String getFormattedDateTime(Date timestamp) {
//        return dateTimeFormatter.format(timestamp);
//    }
//
    public static String getFormattedDateTime(long timeMillis) {
        LocalDate date = Instant.ofEpochMilli(timeMillis).atZone(ZoneId.systemDefault()).toLocalDate();
        return formatter.format(date);
    }
//
//    public static Date parseDate(String date) throws ParseException {
//        return dateFormatter.parse(date);
//    }
//
//    public static Date parseDateTime(String dateTime) throws ParseException {
//        return dateTimeFormatter.parse(dateTime);
//    }
//
//    public String getDateFormat() {
//        return dateFormatter.toPattern();
//    }
}
