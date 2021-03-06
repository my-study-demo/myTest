package com.kely.design.pattern.reactor.demo1;

/**
 * @Description: 继承自EventHandler的具体事件处理器的实现类，一般根据事件不同的状态来定义不同的处理器
 * @Author yangqh
 * @Date 16:18 2019/1/14
 * @Param
 * @Return
 **/
public class AcceptEventHandler extends EventHandler {
    private Selector selector;

    public AcceptEventHandler(Selector selector) {
        this.selector = selector;
    }

    @Override
    public void handle(Event event) {
        //处理Accept的event事件
        if (event.getType() == EventType.ACCEPT) {

            //TODO 处理ACCEPT状态的事件

            //将事件状态改为下一个READ状态，并放入selector的缓冲队列中
            Event readEvent = new Event();
            readEvent.setSource(event.getSource());
            readEvent.setType(EventType.READ);

            selector.addEvent(readEvent);
        }
    }
}