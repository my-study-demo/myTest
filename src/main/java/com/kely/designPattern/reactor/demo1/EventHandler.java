package com.kely.designPattern.reactor.demo1;

/**
 * @Description: event处理器的抽象类
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