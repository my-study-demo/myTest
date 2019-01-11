package com.kely;/**
 * Created by YMO on 2018/9/13.
 */

import com.kely.web.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Descrition jdk8新特性
 * @Author YMO
 * @Date 2018/9/13 14:39
 **/
public class MyJdk8Test {
    public static void main(String[] args) {

        Subject s1 = new Subject(1, "1", 1, 1);
        Subject s2 = new Subject(2, "1", 2, 2);
        Subject s3 = new Subject(3, "2", 3, 3);
        Subject s4 = new Subject(4, "2", 2, 2);
        Subject s5 = new Subject(5, "3", 3, 4);
        List<Subject> list = new ArrayList<Subject>();
        list.add(s1);
        list.add(s2);
        list.add(s4);
        list.add(s3);
        list.add(s5);

        Map<String, Integer> map = list.stream().collect(Collectors.groupingBy(Subject::getNo, Collectors.summingInt(Subject::getScore)));
        System.out.println("1、↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓指定列分组，指定列聚合");
        System.out.println(map);

        System.out.println("2、↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓指定列分组有序获取第一个");
        Map<String, Subject> dtoMap = list.stream().collect(Collectors.toMap(Subject::getNo, a -> a, (k1, k2) -> k1));
        Set<String> set = dtoMap.keySet();
        for (String s : set) {
            Subject subject = dtoMap.get(s);
            System.out.println(subject.toString());
        }

        System.out.println("3、↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓获取已指定列为key，对象为value");
        Map<Integer, Subject> tnMap = list.stream().collect(Collectors.toMap(tn -> tn.getId(), tn -> tn));
        Set<Integer> set1 = tnMap.keySet();
        for (Integer s : set1) {
            Subject subject = tnMap.get(s);
            System.out.println(s + ":" + subject.toString());
        }

        System.out.println("4、↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓获取对象中指定列集合");
        List<String> ids = list.stream().map(Subject::getNo).collect(Collectors.toList());
        System.out.println(ids);

    }
}
