package com.company.goods;

import com.company.Marketable;

public abstract class Product implements Marketable {
    protected ProductNames productName;

    public Product(ProductNames productName) {
        this.productName = productName;
    }

    @Override
    public Double buy(Double amount) {
        return 0.0;
    }

    @Override
    public Double sell(Double amount) {
        return 0.0;
    }

    public static String codeToName(ProductNames productName) {
        String name;
        switch (productName) {
            case BARLEY -> name = "żyto";
            case CANOLA -> name = "rzepak";
            case CHICKEN -> name = "kury";
            case CORN -> name = "kukurydza";
            case COTTON -> name = "bawełna";
            case COW -> name = "krowy";
            case GRASS -> name = "trawa";
            case HORSE -> name = "konie";
            case OAT -> name = "owies";
            case OILSEED_RADISH -> name = "rzodkiew oleista";
            case PIG -> name = "świnie";
            case POTATOE -> name = "ziemniaki";
            case SHEEP -> name = "owce";
            case SOYBEAN -> name = "soja";
            case SUGAR_BEET -> name = "burak cukrowy";
            case SUGARCANE -> name = "trzcina cukrowa";
            case SUNFLOWER -> name = "słonecznik";
            case WHEAT -> name = "pszenica";
            default -> name = "(puste)";
        }
        return name;
    }
}
