package com.mtxul.it.methodology.patterns.behavior.template;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Coffee extends CaffeineBeverage {
    @Override
    void brew() {
        System.out.println("Coffee.brew");
    }

    @Override
    void addCondiments() {
        System.out.println("Coffee.addCondiments");
    }
}

