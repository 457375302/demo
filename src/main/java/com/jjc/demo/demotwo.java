package com.jjc.demo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class demotwo {
    public static void main(String[] args) throws ParseException {


        Date date=new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd日 HH:mm:ss");
        String dateString = format.format(date);
//日期转string
     /*   Date sDate = format.parse(dateString);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sDate);
//增加7天
        cal.add(Calendar.DAY_OF_MONTH, 7);
//Calendar转为Date类型
        date=cal.getTime();
//将增加后的日期存入另一字段
        System.out.println(date);*/
        System.out.println(dateString);
    }
}
