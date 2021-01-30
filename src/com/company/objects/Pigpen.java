package com.company.objects;

import com.company.Main;
import com.company.Market;

public class Pigpen extends Building{
    private int pigAmount;

    public Pigpen(int size) {
        super(size);
    }

    @Override
    public Double autoSell(Market market) {
        return ((pigAmount * (market.getPigPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
