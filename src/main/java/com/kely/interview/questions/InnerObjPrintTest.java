package com.kely.interview.questions;

/**
 * 网络链接：http://www.jianshu.com/p/39f91f3fba32
 * @author yangqh
 * @date 2019/3/10
 **/
public class InnerObjPrintTest {
	private String baseName = "base";
    public InnerObjPrintTest(){
        callName();
    }

    public void callName() {
        System. out. println(baseName);
    }

    static class Sub extends InnerObjPrintTest {
        private String baseName = "sub";
        public void callName() {
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args) {
    	InnerObjPrintTest b = new Sub();
    }
}
