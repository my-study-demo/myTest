package com.kely.design.pattern.reactor.demo1;

/**
 * @Description: 负责启动reactor服务并启动相关服务接收请求
 * @Author yangqh
 * @Date 17:43 2019/1/21
 * @Param
 * @Return
 **/
public class Server {
    Selector selector = new Selector();
    Dispatcher eventLooper = new Dispatcher(selector);
    Acceptor acceptor;

    Server(int port) {
        acceptor = new Acceptor(selector, port);
    }

    public void start() {
        eventLooper.registEventHandler(EventType.ACCEPT, new AcceptEventHandler(selector));
        new Thread(acceptor, "Acceptor-" + acceptor.getPort()).start();
        eventLooper.handleEvents();
    }

    public static void main(String[] args) {
        new Server(10086).start();
    }
}