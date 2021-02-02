package com.company.buildings;

import com.company.Main;
import com.company.Autotradeable;
import com.company.Market;

public abstract class Building implements Autotradeable {
    protected int size;

    public Double getPrice() {
        return this.size * Main.ANIMAL_BUILD_PRICE;
    }

    public Building(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public abstract int getAmount();

    public abstract Double getBuySellPrice(int amount, Market market);

    public abstract void changeAnimalAmount(int amount);

    @Override
    public String toString() {
        String b = getClass().getSimpleName();
        switch (b) {
            case "Barn" -> b = "Stodoła";
            case "Chickencoop" -> b = "Kurnik";
            case "Cowshed" -> b = "Obora";
            case "Fold" -> b = "Owczarnia";
            case "Pigpen" -> b = "Chlew";
            case "Stable" -> b = "Stajnia";
            default -> b = "(nieznany)";
        }
        return "Budynek typu " + b + ", liczba miejsc: " + this.size;
    }
}
