package com.jjc.demo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class demo12 {

    public static void main(String[] args) throws IOException {
        try {


        int i,n=0;
        String[] words;
        String str= "http://7dd-statics.7dingdong.com//data/files/goods/20190712/5d282d4738780.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf8df06fc.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf8952c4c.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf6b02955.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190429/5cc6bf64a9f39.jpg,http://7dd-statics.7dingdong.com//data/files/goods/20190712/5d282d434d4cd.jpg";
        List list=new ArrayList();
        for(i=0;i<str.length();i++){
            if(str.charAt(i)==',') n++;
        }
        words=str.trim().split(",");
        for(i=0; i<str.length()-n; i++) {
            System.out.print(words[i]+"\t");
            InputStream imageStream = getImageStream(words[i]);

            System.out.println(imageStream);
            if (i==n){
                break;
            }
        }
        }catch (Exception  e){
            e.printStackTrace();
        }
    }

    public static InputStream getImageStream(String url) {
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setReadTimeout(5000);
            connection.setConnectTimeout(5000);
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                return inputStream;
            }
        } catch (IOException e) {
            System.out.println("获取网络图片出现异常，图片路径为：" + url);
            e.printStackTrace();
        }
        return null;
    }

    public static File getFile(String url) throws Exception {
        //对本地文件命名
        String fileName = url.substring(url.lastIndexOf("."),url.length());
        File file = null;

        URL urlfile;
        InputStream inStream = null;
        OutputStream os = null;
        try {
            file = File.createTempFile("net_url", fileName);
            //下载
            urlfile = new URL(url);
            inStream = urlfile.openStream();
            os = new FileOutputStream(file);

            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = inStream.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) {
                    os.close();
                }
                if (null != inStream) {
                    inStream.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return file;
    }

    private static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static byte[] image2byte(String path) throws IOException {
        byte[] data = null;
        URL url = null;
        InputStream input = null;
        try{
            url = new URL(path);
            HttpURLConnection httpUrl = (HttpURLConnection) url.openConnection();
            httpUrl.connect();
            httpUrl.getInputStream();
            input = httpUrl.getInputStream();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int numBytesRead = 0;
        while ((numBytesRead = input.read(buf)) != -1) {
            output.write(buf, 0, numBytesRead);
        }
        data = output.toByteArray();
        output.close();
        input.close();
        return data;
    }

    public static DataInputStream getFileStream(String urls){
        URL url = null;
        try {
            url = new URL(urls);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
           /* URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection)httpUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据*/
            return dataInputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
