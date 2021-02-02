package com.company.buildings;

import com.company.Main;
import com.company.Market;

public class Pigpen extends Building{
    private int pigAmount;

    public Pigpen(int size) {
        super(size);
    }

    public Double getBuySellPrice(int amount, Market market) {
        return amount * market.getPigPrice();
    }

    @Override
    public void changeAnimalAmount(int amount) {
        pigAmount += amount;
    }

    @Override
    public int getAmount() {
        return pigAmount;
    }

    @Override
    public Double autoSell(Market market) {
        return ((pigAmount * (market.getPigPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
