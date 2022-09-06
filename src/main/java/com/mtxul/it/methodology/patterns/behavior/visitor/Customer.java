package com.mtxul.it.methodology.patterns.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Customer implements Element {

    private final String name;
    private final List<Order> orders = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void addOrder(Order order) {
        orders.add(order);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
        for (Order order : orders) {
            order.accept(visitor);
        }
    }
}
