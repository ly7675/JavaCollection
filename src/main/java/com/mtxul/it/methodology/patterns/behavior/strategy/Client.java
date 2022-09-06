package com.mtxul.it.methodology.patterns.behavior.strategy;

/**
 * 策略模式：策略模式可以让算法独立于使用它的客户端。
 *
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Client {
    public static void main(String[] args) {
        TwoNum twoNum = new TwoNum();
        twoNum.setOperator(new AddOperator());
        twoNum.operatorTwoNum();
        twoNum.setOperator(new ReduceOperator());
        twoNum.operatorTwoNum();
    }
}
