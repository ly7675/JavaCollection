package com.mtxul.it.methodology.patterns.structure.decorator;

/**
 * 装饰器模式：动态地将责任附加到对象上, 若要扩展功能, 装饰者提供了比继承更有弹性的替代方案。
 * <p>
 * 场景：奶茶动态添加配料。
 *
 * @User: MTXUL
 * @Date: 2022/8/29
 */
public class DecoratorMain {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);
        beverage = new Milk(beverage);
        System.out.println(beverage.cost());
    }

    interface Beverage {
        double cost();
    }

    static class DarkRoast implements Beverage {
        @Override
        public double cost() {
            return 1;
        }
    }

    static class HouseBlend implements Beverage {
        @Override
        public double cost() {
            return 1;
        }
    }

    static abstract class CondimentDecorator implements Beverage {
        protected Beverage beverage;
    }

    static class Milk extends CondimentDecorator {

        public Milk(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public double cost() {
            return 1 + beverage.cost();
        }
    }

    static class Mocha extends CondimentDecorator {

        public Mocha(Beverage beverage) {
            this.beverage = beverage;
        }

        @Override
        public double cost() {
            return 1 + beverage.cost();
        }
    }
}
