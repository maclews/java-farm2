package com.company.objects;

import com.company.Tradeable;
import com.company.goods.Crop;

public class Field implements Tradeable {
    private Double size;
    private Crop crop;
    private FieldStatus status;

    public Field(int size) {
        this.status = FieldStatus.RAW;
    }

    @Override
    public void sell() {

    }

    @Override
    public void buy() {

    }
}
