package com.jjc.choujiang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AwardGroup {
    private List<Award> awardgroup;
    private boolean isAutoReduce; // 是否自动减少数量
    private int total = 0; // 总权数

    public AwardGroup() {
        awardgroup = new ArrayList<Award>();
    }

    public boolean addAward(Award award) {
        total += award.getWeight();
        return awardgroup.add(award);
    }

    public boolean remove(Award award) {
        total -=  award.getWeight();
        return awardgroup.remove(award);
    }

    public List<Award> getAwardgroup() {
        return awardgroup;
    }

    public void setAwardgroup(List<Award> awardgroup) {
        this.awardgroup = awardgroup;
        total = 0;
        for (Award award : awardgroup) {
            total += award.getWeight();
        }
    }

    public boolean isAutoReduce() {
        return isAutoReduce;
    }

    public void setAutoReduce(boolean isAutoReduce) {
        this.isAutoReduce = isAutoReduce;
    }

    public synchronized Award startGetAward() {
        if (awardgroup == null || total <= 0)
            return null;
        Random random = new Random();
        int awardNUmber = random.nextInt(total);
        for (Award award : awardgroup) {
            if (awardNUmber + 1 - award.getWeight() > 0) {
                awardNUmber -= award.getWeight();
                continue;
            }
           /* if (isAutoReduce) {
                award.reduceWeight(1);
                total -= 1;
            }*/
            return award;
        }

        return null;
    }
}

