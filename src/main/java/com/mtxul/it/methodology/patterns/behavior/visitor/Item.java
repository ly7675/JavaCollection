package com.mtxul.it.methodology.patterns.behavior.visitor;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
public class Item implements Element {

    private final String name;

    Item(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
