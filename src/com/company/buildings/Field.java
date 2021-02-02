package com.company.buildings;

import com.company.Main;
import com.company.goods.Crop;
import com.company.goods.Product;
import java.util.Random;

public class Field {
    private int size;
    private Crop crop;
    private boolean readyToHarvest;
    private double protectionCost;
    private int unprotectedWeeks;
    private Random generator = new Random();

    public Field(int size) {
        this.size = size;
        this.unprotectedWeeks = 0;
        this.readyToHarvest = false;
        this.crop = null;
        this.protectionCost = size * Main.FIELD_PROTECTION_COST;
    }

    public int getSize() {
        return size;
    }

    public void weeklyTasks() {
        if (crop != null) {
            unprotectedWeeks++;
            readyToHarvest = crop.grow();
            if (protect()) unprotectedWeeks = 0;
            destroyCrops();
        }
    }

    public boolean isReadyToHarvest() {
        return readyToHarvest;
    }

    private boolean protect() {
        return Main.gamer.accountWithdraw(this.protectionCost);
    }

    private void destroyCrops() {
        double destroyChance = 0.69;     // 9 tygodni przekracza 1
        if (Math.pow(unprotectedWeeks, 0.333) * destroyChance * generator.nextDouble() >= 1) {
            crop = null;
            readyToHarvest = false;
        }
    }

    @Override
    public String toString() {
        String crop_info = "";
        String status;
        if (crop != null) {
            status = (isReadyToHarvest()) ? "Gotowe do zbiorów" : "Rośnie";
            crop_info = "; obsiane/obsadzone: " + Product.codeToName(crop.getProductName()) + "; status: " + status;
        }
        return "Pole o rozmiarze " + size + " ha" + crop_info;
    }
}
