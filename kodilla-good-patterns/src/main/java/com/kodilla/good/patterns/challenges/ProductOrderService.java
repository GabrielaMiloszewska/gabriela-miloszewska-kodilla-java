package com.kodilla.good.patterns.challenges;

public class ProductOrderService {

    private InformationService informationService;
    private OrderService orderService;
    private OrderRepository orderRepository;

    public ProductOrderService(final InformationService informationService, final OrderService orderService, final OrderRepository orderRepository) {
        this.informationService = informationService;
        this.orderService = orderService;
        this.orderRepository = orderRepository;
    }

    public OrderDTO process(final OrderRequest orderRequest) {
        boolean isTransactionCompleted = orderService.order(orderRequest.getUser(), orderRequest.getPurchaseDate(), orderRequest.getPaymentDate(), orderRequest.getPurchasedProduct());
        if (isTransactionCompleted) {
            informationService.inform(orderRequest.getUser(), orderRequest.getPurchasedProduct());
            orderRepository.createOrder(orderRequest.getUser(), orderRequest.getPurchaseDate(), orderRequest.getPaymentDate());
            return new OrderDTO(orderRequest.getUser(), orderRequest.getPurchasedProduct(), true);
        } else {
            return new OrderDTO(orderRequest.getUser(), orderRequest.getPurchasedProduct(), false);
        }
    }
}
