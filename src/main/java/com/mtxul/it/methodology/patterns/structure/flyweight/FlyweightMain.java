package com.mtxul.it.methodology.patterns.structure.flyweight;

import java.util.HashMap;

/**
 * 享元模式：利用共享的方式来支持大量细粒度的对象，这些对象一部分内部状态是相同的。 它让某个类的一个实例能用来提供许多"虚拟实例"
 * 它允许你在消耗少量内存的情况下支持大量对象。
 * <p>
 * 使用示例： 享元模式只有一个目的： 将内存消耗最小化。 如果你的程序没有遇到内存容量不足的问题， 则可以暂时忽略该模式。
 *
 * @User: MTXUL
 * @Date: 2022/8/29
 */
public class FlyweightMain {

    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("aa");
        Flyweight flyweight2 = factory.getFlyweight("aa");
        flyweight1.doOperation("x");
        flyweight2.doOperation("y");
    }

    interface Flyweight {
        void doOperation(String extrinsicState);
    }

    static class ConcreteFlyweight implements Flyweight {

        private final String intrinsicState;

        public ConcreteFlyweight(String intrinsicState) {
            this.intrinsicState = intrinsicState;
        }

        @Override
        public void doOperation(String extrinsicState) {
            System.out.println("Object address: " + System.identityHashCode(this));
            System.out.println("IntrinsicState: " + intrinsicState);
            System.out.println("ExtrinsicState: " + extrinsicState);
        }
    }

    static class FlyweightFactory {

        private final HashMap<String, Flyweight> flyweights = new HashMap<>();

        Flyweight getFlyweight(String intrinsicState) {
            if (!flyweights.containsKey(intrinsicState)) {
                Flyweight flyweight = new ConcreteFlyweight(intrinsicState);
                flyweights.put(intrinsicState, flyweight);
            }
            return flyweights.get(intrinsicState);
        }
    }
}
