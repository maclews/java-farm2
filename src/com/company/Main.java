package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int FARM_CATALOGUE_COUNT = 5;
    private static final List<Farm> farmCatalogue = new ArrayList<>();

    private static void generateFarms() {
        //
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
