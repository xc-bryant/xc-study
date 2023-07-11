package com.xc.study.design.chain;

/**
 * @author bryant
 * @date 2023/7/11
 **/
public class Test {
    public static void main(String[] args) {
        FirstHandler firstHandler = new FirstHandler();
        SecondHandler secondHandler = new SecondHandler();
        ThirdHandler thirdHandler = new ThirdHandler();
        firstHandler.setNextHandler(secondHandler);
        secondHandler.setNextHandler(thirdHandler);
        firstHandler.handle();
    }
}
