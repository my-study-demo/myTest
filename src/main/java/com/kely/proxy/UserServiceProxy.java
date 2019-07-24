package com.kely.proxy;

/**
 * 静态代理
 *
 * @author yangqh
 * @date 2019/7/24
 **/
public class UserServiceProxy implements IUserService {

    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void request() {
        long startTime = System.currentTimeMillis();
        userService.request();
        System.out.println("reques cost :" + (System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        // this is userService
        // reques cost :0
        userServiceProxy.request();
    }
}