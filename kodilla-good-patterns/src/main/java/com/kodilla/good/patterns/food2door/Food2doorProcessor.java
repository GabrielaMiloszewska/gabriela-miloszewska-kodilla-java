package com.kodilla.good.patterns.food2door;

public class Food2doorProcessor {

    private InformationService informationService;
    private OrderService orderService;

    public Food2doorProcessor(InformationService informationService, OrderService orderService) {
        this.informationService = informationService;
        this.orderService = orderService;
    }

    public OrderDTO run(final OrderRequest orderRequest) {
        boolean isOrdered = orderService.toOrder(orderRequest.getOrder(), orderRequest.getOrderNumber());
        if (isOrdered) {
            informationService.inform(orderRequest.getOrder(), orderRequest.getOrderNumber());
            return new OrderDTO(orderRequest.getOrder(),true);
        } else {
            return new OrderDTO(orderRequest.getOrder(),false);
        }
    }
}