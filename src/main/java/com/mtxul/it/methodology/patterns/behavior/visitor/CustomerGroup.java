package com.mtxul.it.methodology.patterns.behavior.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * @User: MTXUL
 * @Date: 2022/9/6
 */
class CustomerGroup {

    private final List<Customer> customers = new ArrayList<>();

    void accept(Visitor visitor) {
        for (Customer customer : customers) {
            customer.accept(visitor);
        }
    }

    void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

