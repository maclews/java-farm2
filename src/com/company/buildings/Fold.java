package com.company.buildings;

import com.company.Main;
import com.company.Market;

public class Fold extends Building{
    private int sheepAmount;

    public Fold(int size) {
        super(size);
    }

    public Double getBuySellPrice(int amount, Market market) {
        return amount * market.getSheepPrice();
    }

    @Override
    public void changeAnimalAmount(int amount) {
        sheepAmount += amount;
    }

    @Override
    public int getAmount() {
        return sheepAmount;
    }

    @Override
    public Double autoSell(Market market) {
        return ((sheepAmount * (market.getSheepPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
