package com.kodilla.good.patterns.challenges;

public class OrderDTO {
    public User user;
    public PurchasedProduct purchasedProduct;
    public boolean isTransactionCompleted;

    public OrderDTO(User user, PurchasedProduct purchasedProduct, boolean isTransactionCompleted) {
        this.user = user;
        this.purchasedProduct = purchasedProduct;
        this.isTransactionCompleted = isTransactionCompleted;
    }

    public User getUser() {
        return user;
    }

    public PurchasedProduct getPurchasedProduct() {
        return purchasedProduct;
    }

    public boolean isTransactionCompleted() {
        return isTransactionCompleted;
    }
}
