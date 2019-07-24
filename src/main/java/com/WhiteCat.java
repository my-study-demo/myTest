package com;

class WhiteCat implements Cat {

    @Override
    public void play() {
        System.out.println("白猫玩");
    }

    @Override
    public void run() {
        System.out.println("白猫跑");
    }
}
