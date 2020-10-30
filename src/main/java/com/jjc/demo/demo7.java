package com.jjc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class demo7 {

    public static String sn(int len,Integer i,String driver){
        String dr = "";
        AtomicInteger z = new AtomicInteger(i);
        z.getAndIncrement();
        if(z.toString().length()>(len-(driver!=null?driver.length():0))){
            dr = driverCheck(driver,len);
            if(dr.equals(".N")){//如超出限定长度并字母都为Z的时候，限定长度加1，dr重新开始，默认为空
                len++;
                dr = "";
            }else{
                z.set(1);
            }
        }else{
            dr = driver;
        }

        if(dr.length()==len){
            //System.out.println(dr);
            return dr;
        }else{
           // System.out.println(String.format("%0"+(len-dr.length())+"d", z.intValue())+dr);
            return dr+String.format("%0"+(len-dr.length())+"d", z.intValue());
        }
    }

    /**
     * 字母有效检查
     * 1.检查字母是否都为Z
     * 2.检查字母长度
     * @param driver
     * @param len
     * @return
     */
    public static String driverCheck(String driver,int len){
        char[] charArray = driver.toCharArray();
        AtomicInteger z = new AtomicInteger(0);

        for (char c : charArray) {
            if(c=='Z'){
                z.getAndIncrement();
            }
        }

        if(z.intValue()==driver.length() && z.intValue()==len){//如所有字母都为Z，并且长度达到限定长度，返回.N
            return ".N";
        }else if(z.intValue()==driver.length() && z.intValue()<len){//如果所有字母都为Z，但长度未达到限定长度，则在调用字母递增方法之前加入@用以递增A
            return driver("@"+driver);
        }else{//以上两个条件都不满足，则直接递增
            return driver(driver);
        }

    }

    /**
     * 字母递增
     * @param driver
     * @return
     */
    public static String driver(String driver){
        if(driver!=null && driver.length()>0){
            char[] charArray = driver.toCharArray();
            AtomicInteger z = new AtomicInteger(0);
            for(int i = charArray.length-1;i>-1;i--){
                if(charArray[i]=='Z'){
                    z.set(z.incrementAndGet());
                }else{
                    if(z.intValue()>0 || i==charArray.length-1){
                        AtomicInteger atomic = new AtomicInteger(charArray[i]);
                        charArray[i]=(char) atomic.incrementAndGet();
                        z.set(0);
                    }
                }
            }

            return String.valueOf(charArray);
        }else{
            return "A";
        }
    }

    public static void main(String[] args) {

        //String sn =


        StringBuffer characters = new StringBuffer();
        StringBuffer letter = new StringBuffer();
        StringBuffer number = new StringBuffer();
        String str = sn(6, 9, "ZZZZZZ");
        char[] strArr = str.toCharArray();
        for (char string : strArr)
        { // 判断是否为字母
             if ((string+"").matches("[a-z]") || (string+"").matches("[A-Z]"))
             { letter.append(string); }
            // 判断是否为数字
             if ((string+"").matches("[0-9]")){
                 number.append(string); }
        }
        Integer num= Integer.parseInt(String.valueOf(number));
        Integer size=str.length();
        List<String> list=new ArrayList<>();
        for (int i=num; i<num+10;i++){
            String sn = sn(size, i, String.valueOf(letter));
            list.add(sn);
        }
        System.out.println(list);
        System.out.println(letter);
        System.out.println(number);
    }

}
