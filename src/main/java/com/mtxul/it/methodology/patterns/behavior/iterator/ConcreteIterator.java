package com.mtxul.it.methodology.patterns.behavior.iterator;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class ConcreteIterator<T> implements Iterator {

    private final T[] items;
    private int position = 0;

    public ConcreteIterator(T[] items) {
        this.items = items;
    }

    @Override
    public Object next() {
        return items[position++];
    }

    @Override
    public boolean hasNext() {
        return position < items.length;
    }
}

