package com.company.objects;

import com.company.Tradeable;
import com.company.goods.Crop;

public class Field implements Tradeable {
    private int size;
    private Crop crop;
    private FieldStatus status;

    public Field(int size) {
        this.size = size;
        this.status = FieldStatus.RAW;
    }

    @Override
    public void sell() {
        //TODO: write sell method for FIELD
    }

    @Override
    public void buy() {
        //TODO: write buy method for FIELD
    }

    @Override
    public String toString() {
        return "Pole o rozmiarze " + size + " ha, obsiane " + crop + "; status: " + status + "\n";
    }
}
