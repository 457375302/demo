package com.jjc.choujiang;

public class choujiang {
    public static void main(String[] args) {

        AwardGroup awardGroup = new AwardGroup();

        awardGroup.setAutoReduce(true); // 是否每抽一次减少一个奖品
        awardGroup.addAward(new Award("奖品1", 0, 10));
        awardGroup.addAward(new Award("奖品2", 0, 10));
        awardGroup.addAward(new Award("奖品3", 0, 10));
        awardGroup.addAward(new Award("奖品4", 0, 10));// Award 分别是 奖品名称 奖品权重（个数） 奖品价格
        awardGroup.addAward(new Award("奖品5", 0, 10));
        awardGroup.addAward(new Award("奖品6", 0, 10));
        awardGroup.addAward(new Award("奖品7", 0, 10));
        awardGroup.addAward(new Award("奖品8", 0, 10));
        awardGroup.addAward(new Award("奖品9", 0, 10));
        awardGroup.addAward(new Award("奖品10", 1000, 10));

        for (int i = 0; i < 1000; i++) {
            System.out.println(awardGroup.startGetAward());
        }

    }
}

