package com.kodilla.good.patterns.food2door;

public class MailService implements InformationService {
    @Override
    public void inform(Order order, long orderNumber) {
        System.out.println("The order number: " + orderNumber + ", for: " + order.getSupplierName() + ", has been completed successfully.");
    }
}