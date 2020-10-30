package com.jjc.demo.xuehua;

public class test {
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        test test=new test();

        test.setId(15);
        test.setName("zs");

    }
}
