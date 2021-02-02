package com.company.buildings;

import com.company.Main;
import com.company.Market;

public class Stable extends Building{
    private int horseAmount;
    public Stable(int size) {
        super(size);
    }

    public Double getBuySellPrice(int amount, Market market) {
        return amount * market.getHorsePrice();
    }

    @Override
    public void changeAnimalAmount(int amount) {
        horseAmount += amount;
    }

    @Override
    public int getAmount() {
        return horseAmount;
    }

    @Override
    public Double autoSell(Market market) {
        return ((horseAmount * (market.getHorsePrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
