package com.jjc.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Objects;

public class demo16 {
    public static void main(String[] args) {
        String str="{\"stepInfoList\":[{\"timestamp\":1600444800,\"step\":2616},{\"timestamp\":1600531200,\"step\":2510},{\"timestamp\":1600617600,\"step\":2203},{\"timestamp\":1600704000,\"step\":2570},{\"timestamp\":1600790400,\"step\":1664},{\"timestamp\":1600876800,\"step\":1805},{\"timestamp\":1600963200,\"step\":1246},{\"timestamp\":1601049600,\"step\":624},{\"timestamp\":1601136000,\"step\":1969},{\"timestamp\":1601222400,\"step\":1825},{\"timestamp\":1601308800,\"step\":2140},{\"timestamp\":1601395200,\"step\":2786},{\"timestamp\":1601481600,\"step\":1857},{\"timestamp\":1601568000,\"step\":67},{\"timestamp\":1601654400,\"step\":26},{\"timestamp\":1601740800,\"step\":489},{\"timestamp\":1601827200,\"step\":0},{\"timestamp\":1601913600,\"step\":211},{\"timestamp\":1602000000,\"step\":749},{\"timestamp\":1602086400,\"step\":2184},{\"timestamp\":1602172800,\"step\":2145},{\"timestamp\":1602259200,\"step\":1656},{\"timestamp\":1602345600,\"step\":1441},{\"timestamp\":1602432000,\"step\":1687},{\"timestamp\":1602518400,\"step\":1803},{\"timestamp\":1602604800,\"step\":1603},{\"timestamp\":1602691200,\"step\":2067},{\"timestamp\":1602777600,\"step\":3123},{\"timestamp\":1602864000,\"step\":1998},{\"timestamp\":1602950400,\"step\":1627},{\"timestamp\":1603036800,\"step\":989}],\"watermark\":{\"timestamp\":1603070402,\"appid\":\"wx412432ea04436f4e\"}}";

        JSONObject jsonObject=JSONObject.parseObject(str);
        System.out.println(jsonObject);

        JSONObject stepInfoListJson = JSONObject.parseObject(str);
        //解析json，获取stepInfoList下面的步数
        JSONArray stepInfoList = JSON.parseArray(stepInfoListJson.getString("stepInfoList"));
        //获取今天的步数
        JSONObject today = Objects.requireNonNull(stepInfoList).getJSONObject(stepInfoList.size()-1);

        Double step= Double.valueOf(today.getString("step"));
        System.out.println(step);
    }


}
