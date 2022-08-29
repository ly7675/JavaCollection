package com.mtxul.it.methodology.patterns.structure.combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合模式： 允许你将对象组合成树形结构来表现"整体/部分"层次结构. 组合能让客户以一致的方式处理个别对象以及对象组合。
 * 场景：军衔
 *
 * @User: MTXUL
 * @Date: 2022/8/29
 */
public class CombinationMain {
    public static void main(String[] args) {
        Composite root = new Composite("root");
        Component node1 = new Leaf("1");
        Component node2 = new Composite("2");
        Component node3 = new Leaf("3");
        root.add(node1);
        root.add(node2);
        root.add(node3);
        Component node21 = new Leaf("21");
        Component node22 = new Composite("22");
        node2.add(node21);
        node2.add(node22);
        Component node221 = new Leaf("221");
        node22.add(node221);
        root.print();
    }

    static abstract class Component {
        protected String name;

        public Component(String name) {
            this.name = name;
        }

        public void print() {
            print(0);
        }

        abstract void print(int level);

        abstract public void add(Component component);

        abstract public void remove(Component component);
    }

    static class Composite extends Component {

        private final List<Component> child;

        public Composite(String name) {
            super(name);
            child = new ArrayList<>();
        }

        @Override
        void print(int level) {
            for (int i = 0; i < level; i++) {
                System.out.print("--");
            }
            System.out.println("Composite:" + name);
            for (Component component : child) {
                component.print(level + 1);
            }
        }

        @Override
        public void add(Component component) {
            child.add(component);
        }

        @Override
        public void remove(Component component) {
            child.remove(component);
        }
    }

    static class Leaf extends Component {
        public Leaf(String name) {
            super(name);
        }

        @Override
        void print(int level) {
            for (int i = 0; i < level; i++) {
                System.out.print("--");
            }
            System.out.println("left:" + name);
        }

        @Override
        public void add(Component component) {
            throw new UnsupportedOperationException(); // 牺牲透明性换取单一职责原则，这样就不用考虑是叶子节点还是组合节点
        }

        @Override
        public void remove(Component component) {
            throw new UnsupportedOperationException();
        }
    }
}
