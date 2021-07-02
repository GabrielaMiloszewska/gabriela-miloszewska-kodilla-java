package com.kodilla.good.patterns.food2door;

public class OrderServiceImpl implements OrderService {

    @Override
    public boolean toOrder(Order order, long orderNumber) {
        if(order != null){
            System.out.println("There was made an order, number: " + orderNumber + ", in: " + order.getSupplierName());
        }
        return true;
    }
}