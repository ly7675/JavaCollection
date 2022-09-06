package com.mtxul.it.methodology.patterns.behavior.template;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Tea extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Tea.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Tea.addCondiments");
    }
}
