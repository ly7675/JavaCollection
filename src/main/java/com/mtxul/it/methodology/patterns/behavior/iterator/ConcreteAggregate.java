package com.mtxul.it.methodology.patterns.behavior.iterator;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class ConcreteAggregate implements Aggregate {

    private final Integer[] items;

    public ConcreteAggregate() {
        items = new Integer[10];
        for (int i = 0; i < items.length; i++) {
            items[i] = i;
        }
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator<Integer>(items);
    }
}
