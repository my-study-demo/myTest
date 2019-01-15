package com.kely.design.pattern.iterator;

/**
 * @Description: 具体容器角色(ConcreteAggregate)
 * @Author yangqh
 * @Date 16:41 2019/1/15
 * @Param
 * @Return
 **/
public class ConcreteAggregate implements List {

    private Object[] list;
    private int size;
    private int index;

    public ConcreteAggregate() {
        index = 0;
        size = 0;
        list = new Object[100];
    }

    @Override
    public void add(Object obj) {
        list[index++] = obj;
        size++;
    }

    @Override
    public Iterator iterator() {

        return new ConcreteIterator(this);
    }

    @Override
    public Object get(int index) {

        return list[index];
    }

    @Override
    public int getSize() {

        return size;
    }

}