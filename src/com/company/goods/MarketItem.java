package com.company.goods;

public class MarketItem extends Product {
    Double amount;

    public MarketItem(ProductNames productName, Double amount) {
        super(productName);
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
