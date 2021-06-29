package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchasedProductOrderRepository implements OrderRepository {
    @Override
    public void createOrder(User user, LocalDateTime purchaseDate, LocalDateTime paymentDate) {
        System.out.println("The order was created.");
    }
}
