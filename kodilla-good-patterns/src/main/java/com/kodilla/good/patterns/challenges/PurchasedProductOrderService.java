package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class PurchasedProductOrderService implements OrderService {
    @Override
    public boolean order(User user, LocalDateTime purchaseDate, LocalDateTime paymentDate, PurchasedProduct purchasedProduct) {
        if(purchasedProduct != null){
            System.out.println(user.getNickName() + " purchased " + purchasedProduct.getProductName());
        }
        return true;
    }
}
