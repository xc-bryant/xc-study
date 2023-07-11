package com.xc.study.design.chain;

/**
 * @author bryant
 * @date 2023/7/11
 **/
public class ThirdHandler extends AbstractHandler{
    private int play() {
        return 95;
    }
    @Override
    protected void handle() {
        System.out.println("这是第三关游戏--------------->");
        int score = this.play();
        if (score >= 95) {
            if (this.nextHandler != null) { //判断下一关是否存在
                this.nextHandler.handle();
            }
        }
    }
}
