package com;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: kely [email:yangqinghua39@163.com]
 * @date: 2018/8/27 9:39
 */
public class TestA {
    public static void main(String args[]) {
        List<String> unchangedList = new ArrayList<String>();
        List<String> increaseList = new ArrayList<String>();
        List<String> decreaseList = new ArrayList<String>();

        List<String> specialGroupIdArrayDb = new ArrayList<String>();
        List<String> specialGroupIdArray = new ArrayList<String>();
        specialGroupIdArrayDb.add("1");
        specialGroupIdArrayDb.add("2");

        specialGroupIdArray.add("2");
        specialGroupIdArray.add("3");

        analyseSpecialGroupId(unchangedList, increaseList, decreaseList, specialGroupIdArrayDb, specialGroupIdArray);

        System.out.println(unchangedList);
        System.out.println(increaseList);
        System.out.println(decreaseList);

    }

    private static void analyseSpecialGroupId(List<String> unchangedList, List<String> increaseList, List<String> decreaseList, List<String> specialGroupIdArrayDb, List<String> specialGroupIdArray) {
        List<String> specialGroupIdArrayDbTemp1 = new ArrayList<String>();
        specialGroupIdArrayDbTemp1.addAll(specialGroupIdArrayDb);
        specialGroupIdArrayDb.retainAll(specialGroupIdArray);
        unchangedList.addAll(specialGroupIdArrayDb);
        List<String> specialGroupIdArrayDbTemp2 = new ArrayList<String>();
        specialGroupIdArrayDbTemp2.addAll(specialGroupIdArrayDbTemp1);
        specialGroupIdArrayDbTemp1.removeAll(specialGroupIdArray);
        decreaseList.addAll(specialGroupIdArrayDbTemp1);
        specialGroupIdArray.removeAll(specialGroupIdArrayDbTemp2);
        increaseList.addAll(specialGroupIdArray);
    }
}
