package com.xc.study.design.chain;

/**
 * @author bryant
 * @date 2023/7/11
 **/
public class FirstHandler extends AbstractHandler{
    private int play(){
        return 80;
    }
    @Override
    protected void handle() {
        System.out.println("这是第一关游戏--------------->");
        int score = this.play();
        if (score >= 80) {
            if (this.nextHandler != null) { //判断下一关是否存在
                this.nextHandler.handle();
            }
        }
    }
}
