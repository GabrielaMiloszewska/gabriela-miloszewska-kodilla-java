package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Supplier {

    private double fiveYearsOfCooperationSupplement = 1.5;

    @Override
    public double process(Order order) {
        double standardPrice = order.getPricePerKg() * order.getProductQuantityInKg();
        double priceWithTheSupplement = standardPrice * fiveYearsOfCooperationSupplement;
        return priceWithTheSupplement;
    }
}
