package com.company;

import com.company.objects.Building;
import com.company.objects.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int FARM_CATALOGUE_COUNT = 5;
    private static final List<Farm> farmCatalogue = new ArrayList<>();

    private static void generateFarms() {
        int maxFields = 5;
        int maxBuildings = 5;
        int maxFieldSize = 20;
        Random generator = new Random();
        for (int i = 0; i < FARM_CATALOGUE_COUNT; i++) {
            List<Field> fieldList = new ArrayList<>();
            int noOfFields = Math.abs(generator.nextInt()) % maxFields + 1;
            for (int f = 0; f < noOfFields; f++) {
                int fieldSize = (int) (Math.floor(generator.nextDouble() * maxFieldSize) + 1);
                fieldList.add(new Field(fieldSize));
            }
            List<Building> buildingList = new ArrayList<>();
            int noOfBuildings = Math.abs(generator.nextInt()) % maxBuildings + 1;
            for (int b = 0; b < noOfBuildings; b++) {
                //
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("+---------------------+");
        System.out.println("| SAMOOBRONA CHŁOPSKA |");
        System.out.println("|   symulator farmy   |");
        System.out.println("+---------------------+");
        generateFarms();
        Market market = new Market();
        System.out.println("Rozpocznij niesamowitą przygodę - kup jedną z poniższych farm:");
        Scanner sc = new Scanner(System.in);
        int farmChoice;
        do {
            System.out.println("Którą farmę chcesz zakupić?");
            System.out.println("Podaj liczbę od 1 do " + FARM_CATALOGUE_COUNT);
            farmChoice = sc.nextInt();
            if (farmChoice == 0) return;
            else if (farmChoice < 0 || farmChoice > FARM_CATALOGUE_COUNT)
                System.out.println("[ BŁĄD ] Liczba spoza zakresu!");
        } while (farmChoice < 0 || farmChoice > FARM_CATALOGUE_COUNT);
        Player gamer = new Player(farmCatalogue.get(farmChoice), market);
    }
}
