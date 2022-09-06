package com.mtxul.it.methodology.patterns.behavior.visitor;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public interface Visitor {
    void visit(Customer customer);

    void visit(Order order);

    void visit(Item item);
}
