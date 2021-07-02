package com.kodilla.good.patterns.food2door;

public class Order {

    private String supplierName;
    private String productName;
    private int productQuantityInKg;
    private double pricePerKg;

    public Order(String supplierName, String productName, int productQuantityInKg, double pricePerKg) {
        this.supplierName = supplierName;
        this.productName = productName;
        this.productQuantityInKg = productQuantityInKg;
        this.pricePerKg = pricePerKg;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductQuantityInKg() {
        return productQuantityInKg;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }
}