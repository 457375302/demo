package com.jjc.demo;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class demo9 {
    //自动生成名字（中文）
     public static String getRandomJianHan(int len) {
                 String ret = "";
                for (int i = 0; i < len; i++) {
                        String str = null;
                        int hightPos, lowPos; // 定义高低位
                        Random random = new Random();
                        hightPos = (176 + Math.abs(random.nextInt(39))); // 获取高位值
                    lowPos = (161 + Math.abs(random.nextInt(93))); // 获取低位值
                         byte[] b = new byte[2];
                        b[0] = (new Integer(hightPos).byteValue());
                        b[1] = (new Integer(lowPos).byteValue());
                         try {
                               str = new String(b, "GBK"); // 转成中文
                           } catch (UnsupportedEncodingException ex) {
                                ex.printStackTrace();
                            }
                        ret += str;
                    }
                return ret;
            }

             //生成随机用户名，数字和字母组成,
             public static String getStringRandom(int length) {

                 String val = "";
                Random random = new Random();

                //参数length，表示生成几位随机数
                for(int i = 0; i < length; i++) {

                        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                        //输出字母还是数字
                        if( "char".equalsIgnoreCase(charOrNum) ) {
                                 //输出是大写字母还是小写字母
                                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                                 val += (char)(random.nextInt(26) + temp);
                            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                                val += String.valueOf(random.nextInt(10));
                             }
                    }
                 return val;
            }

    public static void main(String[] args) {
        int max=6,min=2;
       int ran2 = (int) (Math.random()*(max-min)+min);
        String han = getRandomJianHan(ran2);
        System.out.println(han);
        String phone = "18771632488";
        System.out.println(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        System.out.println(phone+date);

        String stringRandom ="用户"+ getStringRandom(8);
        System.out.println(stringRandom);
    }
}
