package com.kely.design.pattern.reactor.demo1;

/**
 * @Description: 处理事件的抽象类，里面包含了不同事件处理器的公共逻辑和公共对象
 * @Author yangqh
 * @Date 16:18 2019/1/14
 * @Param
 * @Return
 **/
public abstract class EventHandler {

    private InputSource source;

    public abstract void handle(Event event);

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }
}