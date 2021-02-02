package com.company.buildings;

import com.company.Main;
import com.company.Market;

public class Chickencoop extends Building{
    private int chickenAmount;

    public Chickencoop(int size) {
        super(size);
    }

    public Double getBuySellPrice(int amount, Market market) {
        return amount * market.getChickenPrice();
    }

    @Override
    public void changeAnimalAmount(int amount) {
        chickenAmount += amount;
    }

    @Override
    public int getAmount() {
        return chickenAmount;
    }

    @Override
    public Double autoSell(Market market) {
        return ((chickenAmount * (market.getChickenPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
