package com.mtxul.it.methodology.patterns.structure.facade;

/**
 * 外观模式：它提供了一个统一的接口，用来访问子系统中的一群接口，从而让子系统更容易使用
 * 最少知识原则: 只和你的密友谈话。也就是说客户对象所需要交互的对象应当尽可能少。
 *
 * @User: MTXUL
 * @Date: 2022/8/27
 */
public class Facade {

    private final TV tv = new TV();

    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.watchTV();
    }

    private void watchTV() {
        tv.turnOn();
        tv.setCD();
        tv.watching();
    }

    static class TV {
        public void turnOn() {
            System.out.println("turn on tv");
        }

        public void setCD() {
            System.out.println("set the cd");
        }

        public void watching() {
            System.out.println("watch the tv");
        }
    }
}
