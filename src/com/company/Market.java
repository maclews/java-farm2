package com.company;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private List<Double> marketPrice;

    public Market() {
        marketPrice = new ArrayList<>();
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
}
