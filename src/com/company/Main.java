package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("+---------------------+");
        System.out.println("| SAMOOBRONA CHŁOPSKA |");
        System.out.println("|   symulator farmy   |");
        System.out.println("+---------------------+");
        System.out.println("Rozpocznij niesamowitą przygodę - kup jedną z poniższych farm:");
        printFarms();
        Scanner sc = new Scanner(System.in);
        int farmChoice = sc.nextInt();
        // ASSIGN FARM
    }

    private static void printFarms() {
        //
    }
}
