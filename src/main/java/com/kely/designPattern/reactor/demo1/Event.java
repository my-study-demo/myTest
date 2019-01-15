package com.kely.designPattern.reactor.demo1;

/**
 * @Description: reactor模式中内部处理的event类
 * @Author yangqh
 * @Date 16:18 2019/1/14
 * @Param
 * @Return
 **/
public class Event {
    private InputSource source;
    private EventType type;

    public InputSource getSource() {
        return source;
    }

    public void setSource(InputSource source) {
        this.source = source;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }
}