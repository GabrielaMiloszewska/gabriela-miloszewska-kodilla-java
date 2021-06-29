package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {

    private User user;
    private LocalDateTime purchaseDate;
    private LocalDateTime paymentDate;
    private PurchasedProduct purchasedProduct;

    public OrderRequest(User user, LocalDateTime purchaseDate, LocalDateTime paymentDate, PurchasedProduct purchasedProduct) {
        this.user = user;
        this.purchaseDate = purchaseDate;
        this.paymentDate = paymentDate;
        this.purchasedProduct = purchasedProduct;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public PurchasedProduct getPurchasedProduct() {
        return purchasedProduct;
    }
}
