package com.kely;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class WhySerialversionUID {

    public static void objectToFile(Object obj, String fileName) throws Exception {
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(fileName));
        oo.writeObject(obj);
        oo.close();
    }

    public static Object getObjectFromFile(String fileName) throws Exception {
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(
                fileName));
        Person crab_back = (Person) oi.readObject();
        oi.close();
        return crab_back;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "crab_file";//文件名

        // 这里是把对象序列化到文件
        Person crab = new Person();
        crab.setName("Mr.Crab");

        //储存到文件中
//        objectToFile(crab,fileName);

        // 这里是把对象序列化到文件，我们先注释掉，一会儿用
        Person crabBack = (Person) getObjectFromFile(fileName);
        //Dog crabBack = (Dog) getObjectFromFile(fileName);
        System.out.println("Hi, My name is " + crabBack.getName()+",age="+crabBack.getAddress());

    }
}