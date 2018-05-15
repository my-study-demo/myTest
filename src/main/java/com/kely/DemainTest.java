package com.kely;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DemainTest {

    public static void main(String[] args) {
        List<Item> rtn = new ArrayList<Item>();

        List<Option> options1 = new ArrayList<Option>();
        Option option11 = new Option(1,"L","");
        Option option12 = new Option(2,"M","");
        options1.add(option11);
        options1.add(option12);
        Item item1 = new Item(1,"尺寸",options1);

        List<Option> options2 = new ArrayList<Option>();
        Option option21 = new Option(3,"白色","");
        Option option22 = new Option(4,"红色","");
        options2.add(option21);
        options2.add(option22);
        Item item2 = new Item(2,"颜色",options2);

        rtn.add(item1);
        rtn.add(item2);
        String str = JSON.toJSON(rtn).toString();
        System.out.println(str);

        List<Item> itemList = JSONObject.parseArray(str,Item.class);
        for (Item i : itemList){
            System.out.println(i.getSpecId()+":"+i.getSpecName());
            for (Option o : i.getOptions()){
                System.out.println("---->"+o.getId()+":"+o.getName());
            }
        }


    }
}
