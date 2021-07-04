package com.kodilla.good.patterns.food2door;

public class ExtraFoodShop implements Supplier {

    private double supplement = 1.5;

    @Override
    public void process(Order order) {
        double standardPrice = order.getPricePerKg() * order.getProductQuantityInKg();
        double priceWithTheSupplement = standardPrice * supplement;
        System.out.println("The price for the order including 5 years of cooperation supplement: " + priceWithTheSupplement + " PLN.");
    }
}
