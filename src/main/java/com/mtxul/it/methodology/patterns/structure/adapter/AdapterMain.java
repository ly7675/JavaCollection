package com.mtxul.it.methodology.patterns.structure.adapter;

/**
 * 适配器：将一个类的接口, 转换成客户期望的另一个接口。 适配器让原本接口不兼容的类可以合作无间。 对象适配器使用组合, 类适配器使用多重继承。
 * java.util.Arrays#asList()
 * java.util.Collections#list()
 *
 * @User: MTXUL
 * @Date: 2022/8/27
 */
public class AdapterMain {
    public static void main(String[] args) {
        new ChickenToDuckAdapter(new WildChicken()).gaga();
    }

    interface Duck {
        void gaga();
    }

    interface Chicken {
        void gigi();
    }

    static class WildDuck implements Duck {
        @Override
        public void gaga() {
            System.out.println("ga ga");
        }
    }

    static class WildChicken implements Chicken {
        @Override
        public void gigi() {
            System.out.println("gi gi");
        }
    }

    static class ChickenToDuckAdapter implements Duck {
        private final Chicken chicken;

        public ChickenToDuckAdapter(Chicken chicken) {
            this.chicken = chicken;
        }

        @Override
        public void gaga() {
            chicken.gigi();
        }
    }
}
