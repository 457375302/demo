package com.jjc.demo.xuehua;

public class xuehuademo {
    //---------------测试---------------
    public static void main(String[] args) {
        long startTime=System.nanoTime();
        long startTime1=System.currentTimeMillis();
        xuehua worker = new xuehua(1,1,1);
        for (int i = 0; i <3; i++) {
            System.out.println("px"+worker.nextId());

        }
        long endTime=System.nanoTime();
        long endTime1=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"微秒");
        System.out.println("程序运行时间： "+(endTime1-startTime1)+"毫米");
    }
}

