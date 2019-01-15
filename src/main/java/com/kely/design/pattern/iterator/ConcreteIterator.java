package com.kely.design.pattern.iterator;

/**
 * @Description: 具体迭代器角色(Concrete Iterator)
 * @Author yangqh
 * @Date 16:39 2019/1/15
 * @Param
 * @Return
 **/
public class ConcreteIterator implements Iterator {
    private List list;
    private int index;

    public ConcreteIterator(List list) {
        super();
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (index >= list.getSize()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        Object object = list.get(index);
        index++;
        return object;
    }

}