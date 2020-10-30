package com.jjc.demo;

import java.util.Scanner;

public class demo13 {
    public static void main(String[] args) {
        int i,n=0;
        String[] words;
        Scanner sc=new Scanner(System.in);
        System.out.println ("请输入bai一串数字du，以zhi逗号隔开dao:");
        String str= "http://7dd-statics.7dingdong.com//data/files/goods/20190712/5d282d4738780.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf8df06fc.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf8952c4c.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf6b02955.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf64a9f39.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190712/5d282d434d4cd.jpg";
        for(i=0;i<str.length();i++){
            if(str.charAt(i)==',') n++;
        }
        words=str.trim().split(",");
        for(i=0; i<str.length()-n; i++) {
            System.out.print(words[i]+"\t");
        }
    }
}
