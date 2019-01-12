package com.kely.thread.concurrentMap;

import java.util.NavigableSet;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @Description: TODO
 * @Author yangqh
 * @Date 18:22 2019/1/11
 **/
public class ConcurrentNavigableMapTest {

    public static void main(String[] args) {

        ConcurrentNavigableMap map = new ConcurrentSkipListMap();

        map.put("4", "four");
        map.put("1", "one");
        map.put("2", "two");
        map.put("3", "three");

        //返回一个包含了小于给定 toKey 的 key 的子 map。
        ConcurrentNavigableMap headMap = map.headMap("2");
        System.out.println("headMap=" + headMap);

        //返回一个包含了不小于给定 fromKey 的 key 的子 map。
        ConcurrentNavigableMap tailMap = map.tailMap("2");
        System.out.println("tailMap=" + tailMap);

        //返回原始 map 中，键介于 from(包含) 和 to (不包含) 之间的子 map
        ConcurrentNavigableMap subMap = map.subMap("2", "3");
        System.out.println("subMap=" + subMap);

        //返回原始map key降序的map
        ConcurrentNavigableMap descendingMap = map.descendingMap();
        System.out.println("descendingMap=" + descendingMap);

        //返回原始map key降序 的key集合
        NavigableSet<String> descendingKeySet = map.descendingKeySet();
        System.out.println("descendingKeySet=" + descendingKeySet);

        //返回原始map key升序 的key集合
        NavigableSet navigableSet = map.navigableKeySet();
        System.out.println("navigableSet=" + navigableSet);
    }
}
