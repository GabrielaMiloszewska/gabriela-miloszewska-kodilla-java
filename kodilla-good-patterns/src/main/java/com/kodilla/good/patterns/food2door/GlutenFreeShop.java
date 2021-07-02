package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Supplier {

    private double nineYearsOfCooperationSupplement = 1.9;

    @Override
    public double process(Order order) {
        double standardPrice = order.getPricePerKg() * order.getProductQuantityInKg();
        double priceWithTheSupplement = standardPrice * nineYearsOfCooperationSupplement;
        return priceWithTheSupplement;
    }
}