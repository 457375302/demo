package com.jjc.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class demo3 {

    static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws ParseException {


        Date date = new Date();

       /* System.out.println("今天开始时间：" + getStartOfDay(date));
        System.out.println("今天结束时间：" + getEndOfDay(date));
*/
        Date date1 = dateUtil(date);
        String format =getStartOfDay(date);
        String format1 = getEndOfDay(date);
        System.out.println(format);
        System.out.println(format1);
        System.out.println("七天："+date1);

        Calendar c = Calendar.getInstance();

        //过去七天
        c.setTime(new Date());
        c.add(Calendar.DATE, + 7);
        Date d = c.getTime();
        String day = sdf.format(d);
        System.out.println("过去七天："+day);

    }

    private static String getEndOfDay(Date date) {

        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());;
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return sdf.format(Date.from(endOfDay.atZone(ZoneId.systemDefault()).toInstant()));
    }

    private static String getStartOfDay(Date date) {
        sdf.format(date);
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochMilli(date.getTime()), ZoneId.systemDefault());
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return  sdf.format(Date.from(startOfDay.atZone(ZoneId.systemDefault()).toInstant()));
    }


    public static Date dateUtil(Date date) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = format.format(date);
        //日期转string
        Date sDate = format.parse(dateString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
        //增加7天
        cal.add(Calendar.DAY_OF_MONTH, 7);
        //Calendar转为Date类型
        date=cal.getTime();
        return date;
    }


}
