package com.bootcamp.desafio.socialmeli.shared.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Calendar calendar = Calendar.getInstance();

    public static String getStringDate(Date date) {
        return simpleDateFormat.format(date);
    }

    public static Date getTwoWeeksAgoDate(Date currentDate) {
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -14);
        return calendar.getTime();
    }
}
