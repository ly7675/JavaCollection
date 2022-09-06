package com.mtxul.it.methodology.patterns.behavior.iterator;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Client {
    public static void main(String[] args) {
        Aggregate aggregate = new ConcreteAggregate();
        Iterator<Integer> iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

