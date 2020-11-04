package com.jjc.demo.xuehua;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class demo16 {
    public static void main(String[] args) {
        //System.out.println("ces");
        //String stringStream = Arrays.stream(list.stream()).map(i -> i.toString()).collect(Collectors.joining(","));
        //String s="3441,3442,3444,3612,3651";
        String s="3441,3442";
        List<Integer> listPushUserStr = Arrays.stream(s.split(","))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.reverse(listPushUserStr);
        //listPushUserStr.remove(0);
            Integer userPushStrIndex = null;
        if (2 >= listPushUserStr.size()){
            userPushStrIndex = listPushUserStr.get(listPushUserStr.size() - 1);
        }else {
            userPushStrIndex = listPushUserStr.get(2);
        }
    System.out.println("为0："+userPushStrIndex);


    listPushUserStr.forEach(System.out::println);

}
}
