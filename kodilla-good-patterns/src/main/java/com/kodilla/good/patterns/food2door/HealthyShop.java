package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Supplier {

    private double twoYearsOfCooperationSupplement = 1.2;

    @Override
    public double process(Order order) {
        double standardPrice = order.getPricePerKg() * order.getProductQuantityInKg();
        double priceWithTheSupplement = standardPrice * twoYearsOfCooperationSupplement;
        return priceWithTheSupplement;
    }
}