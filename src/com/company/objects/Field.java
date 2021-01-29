package com.company.objects;

import com.company.goods.Crop;
import com.company.goods.Product;

public class Field {
    private int size;
    private Crop crop;
    private FieldStatus status;

    public Field(int size) {
        this.size = size;
        this.status = FieldStatus.RAW;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String crop_info = "";
        if (crop != null)
            crop_info = ", uprawa: " + Product.codeToName(crop.getProductName()) + "; status: " + status;
        return "Pole o rozmiarze " + size + " ha" + crop_info + "\n";
    }
}
