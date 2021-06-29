package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrive() {
        User user1 = new User("Valentine1234", "Valentine", "Kowalski", 124);
        LocalDateTime purchaseDate = LocalDateTime.of(2021, 03, 15, 20, 21);
        LocalDateTime paymentDate = LocalDateTime.of(2021, 03, 15, 20, 39);
        PurchasedProduct purchasedProduct125 = new PurchasedProduct("Reserved shirt, size: s", 3, 76.87, 45674);
        return new OrderRequest(user1, purchaseDate, paymentDate, purchasedProduct125);
    }
}
