package com.company.objects;

import com.company.Main;
import com.company.Market;

public class Cowshed extends Building{
    private int cowAmount;

    public Cowshed(int size) {
        super(size);
    }

    @Override
    public Double autoSell(Market market) {
        return ((cowAmount * (market.getCowPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
