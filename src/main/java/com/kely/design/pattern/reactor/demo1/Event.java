package com.kely.design.pattern.reactor.demo1;

/**
 * @Description: reactor模式的事件类，可以理解为将输入原始对象根据不同状态包装成一个事件类，reactor模式里处理的都是event事件对象
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