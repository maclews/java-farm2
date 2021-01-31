package com.company;

import com.company.objects.Building;
import com.company.objects.Field;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    private Double totalPrice;
    private int noOfFields;
    private int noOfBuildings;
    private final List<Field> fieldList;
    private final List<Building> buildingList;

    public Farm(int noOfFields, int noOfBuildings, List<Field> fieldList, List<Building> buildingList) {
        this.noOfFields = noOfFields;
        this.noOfBuildings = noOfBuildings;
        this.fieldList = fieldList;
        this.buildingList = buildingList;
        this.totalPrice = 0.0;
        for (Field field : fieldList) this.totalPrice += field.getSize() * Main.FIELD_PRICE;
        for (Building building : buildingList) this.totalPrice += building.getPrice();
    }

    public int getNoOfFields() {
        return noOfFields;
    }

    public int getNoOfBuildings() {
        return noOfBuildings;
    }

    public Field getField(int id) {
        return fieldList.get(id);
    }

    public void addField(Field field) {
        this.fieldList.add(field);
        this.noOfFields++;
    }

    public ReturnCode removeField(int id) {
        this.fieldList.remove(id);
        // Dodać kontrolę, jeżeli nie można sprzedawać obsianego pola.
        return ReturnCode.SUCCESS;
    }

    public Building getBuilding(int id) {
        return buildingList.get(id);
    }

    public void addBuilding(Building building) {
        this.buildingList.add(building);
        this.noOfBuildings++;
    }

    public ReturnCode removeBuilding(int id) {
        this.buildingList.remove(id);
        // Dodać kontrolę - nie można sprzedawać budynku ze zwierzętami lub towarem.
        return ReturnCode.SUCCESS;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public List<Building> listBuildings(String type) {
        List<Building> list = new ArrayList<>();
        for (Building building : this.buildingList) {
            if (building.getClass().getSimpleName().equals(type))
                list.add(building);
        }
        return list;
    }

    @Override
    public String toString() {
        StringBuilder text = new StringBuilder("Cena: " + totalPrice + Main.CURRENCY + "\n");
        text.append("Liczba pól: ").append(noOfFields).append("\n");
        for (Field field : fieldList) text.append("* ").append(field).append("\n");
        text.append("Liczba budynków: ").append(noOfBuildings).append("\n");
        for (Building building : buildingList) text.append("* ").append(building).append("\n");
        return text.toString();
    }
}
