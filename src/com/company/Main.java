package com.company;

import com.company.objects.*;
import java.util.*;

public class Main {
    private static final int FARM_CATALOGUE_COUNT = 5;
    private static final List<Farm> farmCatalogue = new ArrayList<>();
    public static final Double STARTING_MONEY = 1000000.0;
    public static final Double FIELD_PRICE = 10000.0;
    public static final Double ANIMAL_BUILD_PRICE = 500.0;
    public static final Double STORAGE_BUILD_PRICE = 50.0;
    public static final String CURRENCY = " CBLN";

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
            final int noOfBuildingTypes = 6;
            for (int b = 0; b < noOfBuildings; b++) {
                int buildingId = Math.abs(generator.nextInt()) % noOfBuildingTypes;
                int buildSize = (Math.abs(generator.nextInt()) % 100 + 1) * 10;
                switch (buildingId) {
                    case 0 -> buildingList.add(new Barn(buildSize * 10));
                    case 1 -> buildingList.add(new Chickencoop(buildSize));
                    case 2 -> buildingList.add(new Cowshed(buildSize));
                    case 3 -> buildingList.add(new Fold(buildSize));
                    case 4 -> buildingList.add(new Pigpen(buildSize));
                    case 5 -> buildingList.add(new Stable(buildSize));
                }
            }
            farmCatalogue.add(new Farm(noOfFields, noOfBuildings, fieldList, buildingList));
        }
        for (int i = 0; i < FARM_CATALOGUE_COUNT; i++) {
            System.out.println("\n[FARMA NR " + (i+1) + "]\n" + farmCatalogue.get(i));
        }
    }

    public static void main(String[] args) {
        System.out.println("+---------------------+");
        System.out.println("| SAMOOBRONA CHŁOPSKA |");
        System.out.println("|   symulator farmy   |");
        System.out.println("+---------------------+");
        System.out.println("\n\n");
        Market market = new Market();
        System.out.println("Rozpocznij niesamowitą przygodę - kup jedną z poniższych farm:");
        generateFarms();
        int farmChoice;
        do {
            System.out.println("\nKtórą farmę chcesz zakupić? -- Podaj liczbę od 1 do " + FARM_CATALOGUE_COUNT + " (0 aby zakończyć): _");
            farmChoice = Main.inputHandler();
            if (farmChoice == 0) return;
            else if (farmChoice < 0 || farmChoice > FARM_CATALOGUE_COUNT)
                System.out.println("[ BŁĄD ] Liczba spoza zakresu!");
            else if (farmCatalogue.get(farmChoice-1).getTotalPrice() > STARTING_MONEY)
                System.out.println("[ BŁĄD ] Cena farmy (" + farmCatalogue.get(farmChoice-1).getTotalPrice() + CURRENCY + ") jest wyższa od dostępnych środków na koncie (" + STARTING_MONEY + CURRENCY + ").");
        } while (farmChoice < 0 || farmChoice > FARM_CATALOGUE_COUNT || farmCatalogue.get(farmChoice-1).getTotalPrice() > STARTING_MONEY);
        Player gamer = new Player(farmCatalogue.get(farmChoice-1), market);
        gamer.play();
    }

    public static int inputHandler() {
        int result;
        Scanner sc = new Scanner(System.in);
        try {
            result = sc.nextInt();
        } catch (InputMismatchException ime) {
            result = Integer.MIN_VALUE;
        }
        return result;
    }
}
