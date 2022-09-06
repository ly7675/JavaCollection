package com.mtxul.it.methodology.patterns.behavior.strategy;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class ReduceOperator implements Operator {
    @Override
    public void execute() {
        System.out.println("两数相减！");
    }
}
