package com.kodilla.good.patterns.food2door;

public class OrderRequest {

    private Order order;
    private long orderNumber;

    public OrderRequest(final Order order, final long orderNumber) {
        this.order = order;
        this.orderNumber = orderNumber;
    }

    public Order getOrder() {
        return order;
    }

    public long getOrderNumber() {
        return orderNumber;
    }
}