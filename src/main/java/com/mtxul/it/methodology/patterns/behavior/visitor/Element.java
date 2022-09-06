package com.mtxul.it.methodology.patterns.behavior.visitor;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public interface Element {
    void accept(Visitor visitor);
}
