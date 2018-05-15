package com.kely;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {

//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.add(Calendar.MONTH, -2);
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(df.format(calendar.getTime()));

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Date> list = new ArrayList<Date>();
        try {
            list.add(df.parse("2018-05-09 12:10:00"));
            list.add(df.parse("2018-05-09 12:09:00"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collections.sort(list, new Comparator<Date>() {
            @Override
            public int compare(Date o1, Date o2) {
                int flag = o1.compareTo(o2);
                return flag;
            }
        });
//        for (Date d : list) {
//            System.out.println(df.format(d));
//        }


        try {
            Date d1 = df.parse("2018-05-09 12:10:10");
            Date d2 = df.parse("2018-05-09 12:19:00");
            System.out.println(interval(d1,d2,12));
        } catch (ParseException e) {
            e.printStackTrace();
        }
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
}
