package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {

        Food2doorProcessor food2doorProcessor = new Food2doorProcessor(new MailService(), new OrderServiceImpl());

        double finalPriceOrder12345 = new ExtraFoodShop().process(new Order("ExtraFoodShop", "onion", 150, 2.98));
        double finalPriceOrder12346 = new HealthyShop().process(new Order("HealthyShop", "tomatoes", 100, 20.45));
        double finalPriceOrder12347 = new GlutenFreeShop().process(new Order("GlutenFreeShop", "gluten free bread", 20, 7.44));

        OrderRequest orderRequest12345 = new OrderRequest(new Order("ExtraFoodShop", "onion", 150, 0.98), 12345);
        OrderRequest orderRequest12346 = new OrderRequest(new Order("HealthyShop", "tomatoes", 100, 3.45), 12346);
        OrderRequest orderRequest12347 = new OrderRequest(new Order("GlutenFreeShop", "gluten free bread", 20, 17.44), 12347);

        food2doorProcessor.run(orderRequest12345);
        System.out.println("The price for the order including supplement: " + finalPriceOrder12345 + " PLN.");
        food2doorProcessor.run(orderRequest12346);
        System.out.println("The price for the order including supplement: " + finalPriceOrder12346 + " PLN.");
        food2doorProcessor.run(orderRequest12347);
        System.out.println("The price for the order including supplement: " + finalPriceOrder12347 + " PLN.");
    }
}