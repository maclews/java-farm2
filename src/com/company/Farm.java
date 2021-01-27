package com.company;

import com.company.objects.Building;
import com.company.objects.Field;
import java.util.List;

public class Farm {
    private int noOfFields;
    private int noOfBuildings;
    private List<Field> fieldList;
    private List<Building> buildingList;

    public Farm(int noOfFields, int noOfBuildings, List<Field> fieldList, List<Building> buildingList) {
        this.noOfFields = noOfFields;
        this.noOfBuildings = noOfBuildings;
        this.fieldList = fieldList;
        this.buildingList = buildingList;
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
}
