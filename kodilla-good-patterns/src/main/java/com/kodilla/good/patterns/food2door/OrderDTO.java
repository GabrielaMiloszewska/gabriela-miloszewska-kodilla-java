package com.kodilla.good.patterns.food2door;

public class OrderDTO {

    private Order order;
    private boolean isOrdered;

    public OrderDTO(final Order order, final boolean isOrdered) {
        this.order = order;
        this.isOrdered = isOrdered;
    }

    public Order getOrder() {
        return order;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}