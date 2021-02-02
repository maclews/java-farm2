package com.company.goods;

import java.util.List;

public class Crop extends Product{
    private Double yield;
    private int growthTime;
    private int weeksSincePlanted;
    private List<Integer> sowWeeks;

    public Crop(ProductNames productName, Double yield, int growthTime, List<Integer> sowWeeks) {
        super(productName);
        this.weeksSincePlanted = 0;
        this.yield = yield;
        this.growthTime = growthTime;
        this.sowWeeks = sowWeeks;
    }

    public boolean grow() {
        weeksSincePlanted++;
        return weeksSincePlanted >= growthTime;
    }

    public ProductNames getProductName() {
        return productName;
    }
}
