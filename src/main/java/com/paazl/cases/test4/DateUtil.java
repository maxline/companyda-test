package com.paazl.cases.test4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    public static LocalDate stringToDate(String dateInString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return LocalDate.parse(dateInString, formatter);
    }

    public static String dateToString(LocalDate date) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("d/MM/yyyy");
        return date.format(pattern);
    }
}
