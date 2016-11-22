package com.qweewp.java.stream;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Example0 {

    /**
     * Change:  Remove unnecessary method call.
     */
    public List<Order> filterOrdersByStatuses(List<Order> orders, Set<Status> appropriateStatuses) {
        return orders.stream()
                .filter(order -> appropriateStatuses.contains(order.getStatus()))
                .collect(toList());
    }

    class Order {
        public Status getStatus() {
            return null; //stub
        }
    }

    class Status {
    }
}
