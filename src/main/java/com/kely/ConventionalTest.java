package com.kely;

import com.kely.entity.T;

import java.math.BigDecimal;
import java.util.*;

public class ConventionalTest {
    public static void main(String[] args) {

        //------------getRanner
//        List<Integer> rtn = new ArrayList<Integer>();
//        List<Integer> baseList = new ArrayList<Integer>();
//        for(int i = 1 ; i < 1001 ; i++){
//            baseList.add(i);
//        }
//        getRanner(baseList,rtn,5);
//        for (int j : rtn){
//            System.out.print(j+"-");
//        }

        //------------getScore
//        List<T> list = new ArrayList<T>();
//        T t1 = new T(3,"200");
//        T t2 = new T(5,"120");
//        T t3 = new T(10,"100");
//        list.add(t1);
//        list.add(t2);
//        list.add(t3);
//        String score = getScore(list,3);
//        System.out.println(score);

        //------------sortByValue
//        Set<Integer> set = new HashSet<Integer>();
//        set.add(new Integer(10000));
//        set.add(new Integer(2999));
//        set.add(new Integer(3000));
//        List<Integer> sortSet = sortByValue(set);
//        for (Integer i : sortSet){
//            System.out.println(i+",");
//        }

        //------------getRandomQuestion
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i=0;i<100000;i++){
//                    System.out.print("--"+i+"---");
//                    getRandomQuestion(7,5);
//                }
//            }
//        });
//        t1.start();

        BigDecimal bd =new BigDecimal(12.999000);//定义一个BigDecimal 类型
        int b=bd.intValue();//转换为int类型
        System.out.println(b);//b=1231;输出结果

    }

    /**
     *
     * @param max
     * @param outMax
     * @return
     */
    private static List<Integer> getRandomQuestion(int max, int outMax){

        //禁用的
        List<Integer> nonList = new ArrayList<Integer>();
        nonList.add(3);
        nonList.add(5);

        if(max - nonList.size() < outMax) {
            System.out.println("not enough!");
            return null;
        }

        List<Integer> rtnList = new ArrayList<Integer>();
        while (true) {
            if(rtnList.size() == outMax){
                break;
            }
            int ran = (int) (Math.random()*max) + 1;
            if(rtnList.contains(ran) || nonList.contains(ran)){
                continue;
            }
            rtnList.add(ran);
        }
        for (Integer i : rtnList) {
            System.out.print(i+",");
        }
        System.out.println();
        return rtnList;
    }

    public static List<Integer> sortByValue(Set<Integer> set){
        List<Integer> list = new ArrayList<Integer>(set);
        Collections.sort(list);
        return list;
    }

    private static String getScore(List<T> list, int second) {
        String score = "" ;
        for(T t : list){
            if(t.getSecond() >= second){
                score = t.getScore();
                break;
            }
        }
        return score;
    }

    private static void getRanner(List<Integer> baseList, List<Integer> rtn,int rtnSize) {
        int ran = (int) (Math.random()*baseList.size());
        rtn.add(baseList.get(ran));
        baseList.remove(ran);
        if(rtn.size() < rtnSize){
            getRanner(baseList,rtn,rtnSize);
        }
    }
}
