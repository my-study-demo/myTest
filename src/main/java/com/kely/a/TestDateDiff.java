package com.kely.a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 计算当前时间距离某时间集合中最近的一个相差分钟数
 */
public class TestDateDiff {
    public static void main(String[] args) {
        List<String> chickEggProdTime = new ArrayList<String>();
        chickEggProdTime.add("10:00");
        chickEggProdTime.add("14:00");
        chickEggProdTime.add("12:00");
        List<Date> chickEggProdTimeVal = new ArrayList<Date>();
        for (String time : chickEggProdTime) {
            String datetime = getDateFormat(new Date(),"yyyy-MM-dd" + " " + time + ":00");
            chickEggProdTimeVal.add(formatDate(datetime,"yyyy-MM-dd HH:mm:ss"));
        }
        Collections.sort(chickEggProdTimeVal, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                int flag = o1.compareTo(o2);
                return flag;
            }
        });
        Date nearlyDate = null;
        Date now = getDateTimeFormat(getDateFormat(new Date(),"yyyy-MM-dd HH:mm:ss"));
        for (Date d : chickEggProdTimeVal) {
            if (d.compareTo(now) > 0) {
                nearlyDate = d;
                break;
            }
        }
        Long diffMin = 0L;
        if (nearlyDate != null) {
            diffMin = interval(now,nearlyDate,12);//相差分钟
        }
        System.out.println(diffMin.intValue());
    }

    public static Long interval(Date from, Date to, int field) {
        Long rtn = null;
        if (from != null && to != null) {
            long interval = to.getTime() - from.getTime();
            switch(field) {
                case 10:
                    rtn = interval / 1000L / 60L / 60L;
                case 11:
                default:
                    break;
                case 12:
                    rtn = interval / 1000L / 60L;
                    break;
                case 13:
                    rtn = interval / 1000L;
                    break;
                case 14:
                    rtn = interval;
            }

            return rtn;
        } else {
            return rtn;
        }
    }

    public static Date getDateTimeFormat(String date) {
        SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return dateTimeFormat.parse(date);
        } catch (ParseException var3) {
            return null;
        }
    }

    public static Date formatDate(String date, String format) {
        try {
            return (new SimpleDateFormat(format)).parse(date);
        } catch (ParseException var3) {
            return null;
        }
    }

    public static String getDateFormat(Date date, String formatStr) {
        return (new SimpleDateFormat(formatStr)).format(date);
    }
}
