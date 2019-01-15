package com.kely.design.pattern.reactor.demo1;

/**
 * @Description: 输入对象，reactor模式中处理的原始输入对象
 * @Author yangqh
 * @Date 16:19 2019/1/14
 * @Param
 * @Return
 **/
public class InputSource {
    private Object data;
    private long id;

    public InputSource(Object data, long id) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        return "InputSource{" +
                "data=" + data +
                ", id=" + id +
                '}';
    }
}