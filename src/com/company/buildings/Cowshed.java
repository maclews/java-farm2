package com.company.buildings;

import com.company.Main;
import com.company.Market;
import com.company.goods.MarketItem;

import java.util.List;

public class Cowshed extends Building{
    private int cowAmount;

    public Cowshed(int size) {
        super(size);
    }

    public Double getBuySellPrice(int amount, Market market) {
        return amount * market.getCowPrice();
    }

    @Override
    public void changeAnimalAmount(int amount) {
        cowAmount += amount;
    }

    @Override
    public List<MarketItem> getMarketItems() {
        return null;
    }

    @Override
    public int getAmount() {
        return cowAmount;
    }

    @Override
    public Double autoSell(Market market) {
        return ((cowAmount * (market.getCowPrice() * 0.9)) + (size * Main.ANIMAL_BUILD_PRICE));
    }

}
