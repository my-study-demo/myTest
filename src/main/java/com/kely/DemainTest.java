package com.kely;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DemainTest {

    public static void main(String[] args) {
        List<Item> rtn = new ArrayList<Item>();

        Spec spec1 = new Spec(1,"大小");
        List<Option> options1 = new ArrayList<Option>();
        Option option11 = new Option(1,"L");
        Option option12 = new Option(2,"M");
        options1.add(option11);
        options1.add(option12);
        Item item1 = new Item(spec1,options1);

        Spec spec2 = new Spec(2,"颜色");
        List<Option> options2 = new ArrayList<Option>();
        Option option21 = new Option(3,"白色");
        Option option22 = new Option(4,"红色");
        options2.add(option21);
        options2.add(option22);
        Item item2 = new Item(spec2,options2);

//        Spec spec3 = new Spec(3,"尺寸");
//        List<Option> options3 = new ArrayList<Option>();
//        Option option31 = new Option(5,"36");
//        Option option32 = new Option(6,"37");
//        options3.add(option31);
//        options3.add(option32);
//        Item item3 = new Item(spec3,options3);

        rtn.add(item1);
        rtn.add(item2);
//        rtn.add(item3);
        System.out.println(JSON.toJSON(rtn));

        String str = "[{\"list\":[{\"name\":\"L\",\"id\":1},{\"name\":\"M\",\"id\":2}],\"spec\":{\"name\":\"大小\",\"id\":1}},{\"list\":[{\"name\":\"白色\",\"id\":3},{\"name\":\"红色\",\"id\":4}],\"spec\":{\"name\":\"颜色\",\"id\":2}}]";
        List<Item> itemList = JSONObject.parseArray(str,Item.class);
        for (Item i : itemList){
            System.out.println(i.getSpec().getId()+":"+i.getSpec().getName());
            for (Option o : i.getList()){
                System.out.println(o.getId()+":"+o.getName());
            }
        }


    }
}
