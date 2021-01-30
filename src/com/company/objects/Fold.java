package com.company.objects;

import com.company.Main;
import com.company.Market;

public class Fold extends Building{
    private int sheepAmount;

    public Fold(int size) {
        super(size);
    }

    @Override
    public Double autoSell(Market market) {
        return ((sheepAmount * (market.getSheepPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
