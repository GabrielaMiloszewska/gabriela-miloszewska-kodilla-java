package com.kodilla.good.patterns.food2door;

public class Application {
    public static void main(String[] args) {

        Food2doorProcessor food2doorProcessor1 = new Food2doorProcessor(new MailService(), new OrderServiceImpl(), new ExtraFoodShop());
        Food2doorProcessor food2doorProcessor2 = new Food2doorProcessor(new MailService(), new OrderServiceImpl(), new HealthyShop());
        Food2doorProcessor food2doorProcessor3 = new Food2doorProcessor(new MailService(), new OrderServiceImpl(), new GlutenFreeShop());


        OrderRequest orderRequest12345 = new OrderRequest(new Order("ExtraFoodShop", "onion", 150, 0.98), 12345);
        OrderRequest orderRequest12346 = new OrderRequest(new Order("HealthyShop", "tomatoes", 100, 3.45), 12346);
        OrderRequest orderRequest12347 = new OrderRequest(new Order("GlutenFreeShop", "gluten free bread", 20, 17.44), 12347);

        food2doorProcessor1.run(orderRequest12345);
        food2doorProcessor2.run(orderRequest12346);
        food2doorProcessor3.run(orderRequest12347);
    }
}