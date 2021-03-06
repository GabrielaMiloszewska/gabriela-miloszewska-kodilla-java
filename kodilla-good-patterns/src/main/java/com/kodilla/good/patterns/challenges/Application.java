package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrive();
        ProductOrderService productOrderService = new ProductOrderService(new MailService(), new PurchasedProductOrderService(), new PurchasedProductOrderRepository());
        productOrderService.process(orderRequest);
    }

}
