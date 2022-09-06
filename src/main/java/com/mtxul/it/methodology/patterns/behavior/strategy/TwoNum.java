package com.mtxul.it.methodology.patterns.behavior.strategy;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class TwoNum {
    private Operator operator;

    public void operatorTwoNum() {
        operator.execute();
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
