package com.company;

import com.company.goods.ProductNames;
import java.util.Random;

public class Market {
    private static final int BASE_AMOUNT = 100000;
    
    private final Random generator;
    private final Double chickenPrice = 10.0;
    private final Double cowPrice = 100.0;
    private final Double horsePrice = 250.0;
    private final Double pigPrice = 50.0;
    private final Double sheepPrice = 75.0;
    private int chickenAmount = BASE_AMOUNT;
    private int cowAmount = BASE_AMOUNT;
    private int horseAmount = BASE_AMOUNT;
    private int pigAmount = BASE_AMOUNT;
    private int sheepAmount = BASE_AMOUNT;

    private final Double wheatPrice = 1.0;
    private final Double barleyPrice = 1.0;
    private final Double oatPrice = 1.0;
    private final Double canolaPrice = 1.0;
    private final Double sunflowerPrice = 1.0;
    private final Double soybeanPrice = 1.0;
    private final Double cornPrice = 1.0;
    private final Double potatoePrice = 1.0;
    private final Double sugarBeetPrice = 1.0;
    private final Double sugarcanePrice = 1.0;
    private final Double cottonPrice = 1.0;
    private final Double oilseedRadishPrice = 1.0;
    private final Double grassPrice = 1.0;
    private int wheatAmount = BASE_AMOUNT;
    private int barleyAmount = BASE_AMOUNT;
    private int oatAmount = BASE_AMOUNT;
    private int canolaAmount = BASE_AMOUNT;
    private int sunflowerAmount = BASE_AMOUNT;
    private int soybeanAmount = BASE_AMOUNT;
    private int cornAmount = BASE_AMOUNT;
    private int potatoeAmount = BASE_AMOUNT;
    private int sugarBeetAmount = BASE_AMOUNT;
    private int sugarcaneAmount = BASE_AMOUNT;
    private int cottonAmount = BASE_AMOUNT;
    private int oilseedRadishAmount = BASE_AMOUNT;
    private int grassAmount = BASE_AMOUNT;

    public Market() {
        generator = new Random();
    }

    public void freeMarket() {
        this.chickenAmount += freeMarketChange();
        this.cowAmount += freeMarketChange();
        this.horseAmount += freeMarketChange();
        this.pigAmount += freeMarketChange();
        this.sheepAmount += freeMarketChange();
        this.wheatAmount += freeMarketChange();
        this.barleyAmount += freeMarketChange();
        this.oatAmount += freeMarketChange();
        this.canolaAmount += freeMarketChange();
        this.sunflowerAmount += freeMarketChange();
        this.soybeanAmount += freeMarketChange();
        this.cornAmount += freeMarketChange();
        this.potatoeAmount += freeMarketChange();
        this.sugarBeetAmount += freeMarketChange();
        this.sugarcaneAmount += freeMarketChange();
        this.cottonAmount += freeMarketChange();
        this.oilseedRadishAmount += freeMarketChange();
        this.grassAmount += freeMarketChange();
    }

    private int freeMarketChange() {
        return this.generator.nextInt() % 5000;
    }

    public Double getVolumeMultiplier(String name, int week) {
        if (week >= this.getActiveWeekStart(name) && week <= this.getActiveWeekEnd(name))
            return 3.5;
        else return 1.0;
    }

    public int getActiveWeekStart(String name) {
        return 0;
    }

    public int getActiveWeekEnd(String name) {
        return 0;
    }

    public Double getChickenPrice() {
        return chickenPrice * (BASE_AMOUNT / chickenAmount);
    }

    public Double getCowPrice() {
        return cowPrice * (BASE_AMOUNT / cowAmount);
    }

    public Double getHorsePrice() {
        return horsePrice * (BASE_AMOUNT / horseAmount);
    }

    public Double getPigPrice() {
        return pigPrice * (BASE_AMOUNT / pigAmount);
    }

    public Double getSheepPrice() {
        return sheepPrice * (BASE_AMOUNT / sheepAmount);
    }

    public Double getMarketItemPrice(ProductNames productName) {
        switch (productName) {
            case WHEAT -> { return wheatPrice * (BASE_AMOUNT / wheatAmount); }
            case BARLEY -> { return barleyPrice * (BASE_AMOUNT / barleyAmount); }
            case OAT -> { return oatPrice * (BASE_AMOUNT / oatAmount); }
            case CANOLA -> { return canolaPrice * (BASE_AMOUNT / canolaAmount); }
            case SUNFLOWER -> { return sunflowerPrice * (BASE_AMOUNT / sunflowerAmount); }
            case SOYBEAN -> { return soybeanPrice * (BASE_AMOUNT / soybeanAmount); }
            case CORN -> { return cornPrice * (BASE_AMOUNT / cornAmount); }
            case POTATOE -> { return potatoePrice * (BASE_AMOUNT / potatoeAmount); }
            case SUGAR_BEET -> { return sugarBeetPrice * (BASE_AMOUNT / sugarBeetAmount); }
            case SUGARCANE -> { return sugarcanePrice * (BASE_AMOUNT / sugarcaneAmount); }
            case COTTON -> { return cottonPrice * (BASE_AMOUNT / cottonAmount); }
            case OILSEED_RADISH -> { return oilseedRadishPrice * (BASE_AMOUNT / oilseedRadishAmount); }
            case GRASS -> { return grassPrice * (BASE_AMOUNT / grassAmount); }
            default -> { return null; }
        }
    }
}
