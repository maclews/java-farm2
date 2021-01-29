package com.company.objects;

import com.company.Autotradeable;
import com.company.Main;
import com.company.ReturnCode;
import com.company.goods.MarketItem;

import java.util.ArrayList;
import java.util.List;

public class Barn extends Building implements Autotradeable {
    List<MarketItem> marketItems;

    public Barn(int size) {
        super(size);
        marketItems = new ArrayList<>();
    }

    public ReturnCode withdraw(String name, Double amount) {
        //TODO("Cargo withdrawal method")
        return ReturnCode.SUCCESS;
    }

    public ReturnCode deposit(String name, Double amount) {
        //TODO("Cargo deposit method")
        return ReturnCode.SUCCESS;
    }

    @Override
    public Double getPrice() {
        return this.size * Main.STORAGE_BUILD_PRICE;
    }

    @Override
    public void sell() {
        for (MarketItem marketItem : marketItems) {
            marketItem.sell(marketItem.getAmount());
        }
    }

    @Override
    public void buy() {
        // Wstępnie przygotowane do automatycznego zaopatrzenia w zasoby
    }
}
