package com.kely;

import java.util.HashMap;

/**
 * @description:
 * @author: kely [email:yangqinghua39@163.com]
 * @date: 2018/5/27 10:26
 */
public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> map = new HashMap<Integer, String>();
        map.put(1,"111");
        map.put(2,"222");
        System.out.println(map.get(1));
    }
}
