package com.kely;

public enum ChickenCureTaskTypeEnum {

    INVISIT((byte) 0x01, "邀请好友"),

    SALES((byte) 0x02, "消费"),

    FEEDCLEAN((byte) 0x03, "喂食和打扫"),

    TRADE((byte) 0x04, "鸡蛋兑换");

    private Byte val;

    private String name;

    ChickenCureTaskTypeEnum(Byte val, String name) {
        this.val = val;
        this.name = name;
    }

    public Byte getVal() {
        return val;
    }

    public String getName() {
        return name;
    }

    public static ChickenCureTaskTypeEnum getEnum(Byte val) {
    	ChickenCureTaskTypeEnum[] values = ChickenCureTaskTypeEnum.values();
        for (ChickenCureTaskTypeEnum object : values) {
            if (object.val.equals(val)) {
                return object;
            }
        }
        return null;
    }

}