package com.mtxul.it.methodology.patterns.behavior.iterator;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public interface Iterator<T> {
    boolean hasNext();

    T next();
}
