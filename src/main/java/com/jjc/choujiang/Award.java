package com.jjc.choujiang;

public class Award {
    public Award() {

    }

    public Award(String name, int weight, int money) {
        this.name = name;
        this.weight = weight;
        this.money = money;
    }

    private String name; // 奖品名称
    private int weight; // 奖品权重
    private int money; // 奖品价值

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void reduceWeight(int reduce) {
        if (weight - reduce < 0) {
            weight = 0;
        } else {
            weight -= reduce;
        }
    }

    @Override
    public String toString() {

        return "恭喜您获得奖品 " + name + " 价值 " + money + "元";
    }

}


