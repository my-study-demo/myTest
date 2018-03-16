package com.kely;

import java.io.Serializable;

public class Person implements Serializable {

    //如果没有指定serialVersionUID，系统会自动生成一个
    private static final long serialVersionUID = 1L;
    private String name;
    //添加这么一个成员变量  
    private String address;   //序列化后如果之前版本没有，就为null

    private int age;

    public String getName() {
      int a = 100;
      return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
