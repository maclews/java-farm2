package com.company.objects;

import com.company.Main;
import com.company.Market;

public class Chickencoop extends Building{
    private int chickenAmount;

    public Chickencoop(int size) {
        super(size);
    }

    @Override
    public Double autoSell(Market market) {
        return ((chickenAmount * (market.getChickenPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
