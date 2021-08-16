package com.dungeon.lesson.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateFormatUtil {
    //todo add other formats
    DATE_AND_TIME("dd.MM.yyyy HH:mm:ss"),
    ONLY_DATE("dd-MM-yyyy");
    private final SimpleDateFormat formatter;

    DateFormatUtil(String pattern) {
        this.formatter = new SimpleDateFormat(pattern);
    }
    public Date parse(String dateString) throws ParseException {
        return formatter.parse(dateString);
    }
    public Date parse(long millis) {
        return new Date(millis);
    }
    public String format(Date date) {
        return formatter.format(date);
    }
}