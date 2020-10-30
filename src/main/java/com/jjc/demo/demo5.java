package com.jjc.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class demo5 {
    public static void main(String[] args) {
        String buf = "123,456789,";


        if (buf.length() > 0) {
            //方法一  : substring
            System.out.println(buf.substring(0, buf.length()-1));
            //方法二 ：replace
           // System.out.println(buf.replace(buf.length() - 1, buf.length(), ""));
            //方法三： deleteCharAt
            //System.out.println(buf.deleteCharAt(buf.length()-1));
        }

     /*   List<String> list=new ArrayList<>();

        list.add("1");
        list.add("2");
        list.add("3");*/

        List<Long> list2=new ArrayList<>();

        list2.add(1L);
        list2.add(2L);
        list2.add(3L);
        System.out.println(list2);
        /*String collect = Arrays.stream(list.stream().toArray(String[]::new)).map(i -> i.toString()).collect(Collectors.joining(","));
        System.out.println(collect);

        String s = list.toString();
        System.out.println(s);

        List<Long> ids = list.stream().map(a -> Long.parseLong(a)).collect(Collectors.toList());
        String userListStr = Arrays.stream(list2.stream().toArray(Long[]::new)).map(i -> i.toString()).collect(Collectors.joining(","));
        System.out.println(ids);*/

        String userListStr = Arrays.stream(list2.stream().toArray(Long[]::new)).map(i -> i.toString()).collect(Collectors.joining(","));
        System.out.println(userListStr);
    }


}
