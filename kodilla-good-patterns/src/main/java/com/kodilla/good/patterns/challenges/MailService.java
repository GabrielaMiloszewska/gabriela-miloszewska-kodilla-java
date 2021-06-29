package com.kodilla.good.patterns.challenges;

public class MailService implements InformationService {
    @Override
    public void inform(User user, PurchasedProduct purchasedProduct) {
        System.out.println("Hello " + user.getNickName() + ", congratulations on your purchase " + purchasedProduct.getProductName() + ". Your transaction has been completed successfully.");
    }
}
