package com.kodilla.good.patterns.challenges;

public class PurchasedProduct {
    public String productName;
    public int quantityOfPurchasedProduct;
    public double pricePLN;
    public long auctionNumber;

    public PurchasedProduct(final String productName, final int quantityOfPurchasedProduct, final double pricePLN, final long auctionNumber) {
        this.productName = productName;
        this.quantityOfPurchasedProduct = quantityOfPurchasedProduct;
        this.pricePLN = pricePLN;
        this.auctionNumber = auctionNumber;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantityOfPurchasedProduct() {
        return quantityOfPurchasedProduct;
    }

    public double getPricePLN() {
        return pricePLN;
    }

    public long getAuctionNumber() {
        return auctionNumber;
    }
}
