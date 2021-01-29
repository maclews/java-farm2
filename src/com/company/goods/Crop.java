package com.company.goods;

import java.util.List;

public class Crop extends Product{
    private GrowthState growthState;
    private Double yield;
    private int growthTime;
    private List<Integer> sowWeeks;

    public Crop(ProductNames productName, Double yield, int growthTime, List<Integer> sowWeeks) {
        super(productName);
        this.growthState = GrowthState.PLANTED;
        this.yield = yield;
        this.growthTime = growthTime;
        this.sowWeeks = sowWeeks;
    }

    public ProductNames getProductName() {
        return productName;
    }
}
