package com.kely.design.pattern.iterator;

import com.kely.design.pattern.iterator.bus.ArtDesigner;
import com.kely.design.pattern.iterator.bus.Leader;
import com.kely.design.pattern.iterator.bus.Coder;
import com.kely.design.pattern.iterator.bus.DoWorker;

public class IteratorTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List list = new ConcreteAggregate();
        list.add(new Coder("程序员"));
        list.add(new ArtDesigner("美工"));
        list.add(new Leader("领导"));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DoWorker worker = (DoWorker) it.next();
            worker.execute(worker.getName());
        }
    }

}