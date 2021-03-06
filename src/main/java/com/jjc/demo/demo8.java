package com.jjc.demo;

import java.util.ArrayList;
import java.util.List;

public class demo8 {

    private String s;

    public demo8(String s){
        this.s = s;
    }

    public demo8() {
        this("unknow");
    }

    public String[] getStr(){
        String[] str_string = s.split("\\d");//  \d 为正则表达式表示[0-9]数字
        return str_string;
    }

    public int[] getNum(){
        String[] num_string = s.split("\\D");  // \D 为正则表达式表示非数字
        String a = "";

        for(String m : num_string){
            a += m;
        }

        String[] num = a.split("");  //将分离出的重新保存在新数组num中不要直接用num_string，  因为在正则表达式对字符串进行选择时若前面的几个字符不符合要求但num_string数组中仍会存有其位置 是空格
        int[] inte = new int[num.length];

        for(int i =0; i < num.length; i++){
            inte[i] = Integer.parseInt(num[i]); //将该数组中的数字存入int数组
        }

        return inte;
    }
    //打印字符串中的字母
    public String printStr(){
        String a = "";
        for(String n : getStr()){
            a += n;
        }
        System.out.println(a);
        return a;
    }
    //打印字符串中的数字
    public String printNum(){
        String a = "";
        for(int n : getNum()){
            a += n;
        }
        System.out.println(a);
        return a;
    }

    public static void main(String[] args) {
        String sn =null;
        List<String> list=new ArrayList<>();
        for (int i=0; i<10;i++) {
            if (sn == null) {
                sn = demo7.sn(6, 00000, "A");
            }
            String[] split = sn.split("\\D");
            String a = "";
            for (String s:split) {
                a += s;
            }


            String[] split1 = sn.split("\\d");
            String b = "";
            for (String in: split1) {
                b += in;
            }
            Integer num= Integer.valueOf(b);
            sn = demo7.sn(6, num, a);
            list.add(sn);
        }
        System.out.println(list.toString());

    }
}
