package com.xc.study.design.chain;

/**
 * @author bryant
 * @date 2023/7/11
 **/
public abstract class AbstractHandler {
    /**
     * 下一个执行者
     */
    protected AbstractHandler nextHandler;

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handle();
}
