package com.company.objects;

import com.company.Main;
import com.company.Market;

public class Stable extends Building{
    private int horseAmount;
    public Stable(int size) {
        super(size);
    }

    @Override
    public Double autoSell(Market market) {
        return ((horseAmount * (market.getHorsePrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
