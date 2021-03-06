package com.google.sample.cast.refplayer.ui;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.sample.cast.refplayer.R;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateFormatter {
    private static final String HOUR_FORMAT = "HH:mm";
    private static final String DAY_FORMAT = "dd";

    public static String format(String stringDate, Context context) {
        Date date = Calendar.getInstance().getTime();
        ParsePosition parsePosition = new ParsePosition(0);
        try {
            date = ISO8601Utils.parse(stringDate, parsePosition);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return format(date, context);
    }

    public static String format(Date date, Context context) {
        String result;
        Calendar now = Calendar.getInstance();
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);
        if (now.get(Calendar.DATE) == givenDate.get(Calendar.DATE)) {
            SimpleDateFormat todayDateFormat = new SimpleDateFormat(HOUR_FORMAT, Locale.US);
            result = context.getString(R.string.video_list_item_date_today,
                    todayDateFormat.format(date));
        } else if (now.get(Calendar.DATE) - givenDate.get(Calendar.DATE) == 1) {
            result = context.getString(R.string.video_list_item_date_yesterday,
                    getMonthString(date, context));
        } else {
            result = getMonthString(date, context);
        }
        return result;
    }

    @NonNull
    private static String getMonthString(Date date, Context context) {
        String result;
        SimpleDateFormat yesterdayDateFormat = new SimpleDateFormat(DAY_FORMAT, Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        String monthName = context.getResources().getStringArray(R.array.months)[month];
        result = context.getString(R.string.video_list_item_month_and_day,
                monthName, yesterdayDateFormat.format(date));
        return result;
    }
}
