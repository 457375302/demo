package com.jjc.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class demo14 {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("F:\\Capture001.png");
        //InputStream inputStream = file.getInputStream();
        InputStream inputStream = new FileInputStream(new File("F:\\Capture001.png"));
        System.out.println(inputStream);
    }
}
