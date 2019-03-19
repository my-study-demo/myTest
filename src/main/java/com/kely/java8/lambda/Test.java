package com.kely.java8.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangqh
 * @date 2019/3/19
 **/
public class Test {
    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();

        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
//        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);
        appleList.add(apple1);
//        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.err.println("分组--->" + groupBy);

        Map<Integer, Apple> appleMap1 = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
        System.out.println("List转Map1--->" + appleMap1);

        Map<Integer, String> appleMap2 = appleList.stream().collect(Collectors.toMap(o -> o.getId(), o -> o.getName()));
        System.out.println("List转Map2--->" + appleMap2);

        List<Apple> appleMap3 = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.out.println("过滤Filter3--->" + appleMap3.get(0).getName());

        BigDecimal totalMoney = appleList.stream().filter(o -> o.getName().equals("香蕉")).map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("条件求和--->" + totalMoney);
    }
}
