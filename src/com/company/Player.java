package com.company;

import com.company.objects.Field;

public class Player {
    private Farm farm;
    private Double account;
    private Market market;

    public Player(Farm farm, Market market) {
        this.farm = farm;
        this.account = Main.STARTING_MONEY;
        this.market = market;
    }

    public void play() {
        while(true) {
            switch (actionMenu()) {
                case 1 -> fieldManager(farm);
                case 6 -> System.out.println("--- STAN FARMY ---\n" + farm);
                case 0 -> { return; }
            }
        }
    }

    private int actionMenu() {
        int choice;
        System.out.println();
        System.out.println("+--------------------------------------+");
        System.out.println("|            M   E   N   U             |");
        System.out.println("+--------------------------------------+");
        System.out.println("[ 1 ] ZIEMA - Kup / Sprzedaj");
        System.out.println("[ 2 ] BUDYNKI - Kup / Sprzedaj");
        System.out.println("[ 3 ] ZWIERZĘTA - Kup / Sprzedaj");
        System.out.println("[ 4 ] ZASOBY - Kup / Sprzedaj");
        System.out.println("[ 5 ] ROŚLINY - Posadź / Zbierz");
        System.out.println("*--------------------------------------*");
        System.out.println("[ 6 ] FARMA - pokaż stan");
        System.out.println("[ 7 ] ZAPASY - pokaż stan");
        System.out.println("[ 8 ] ZWIERZĘTA - pokaż stan");
        System.out.println("[ 9 ] ROŚLINY - pokaż stan");
        System.out.println("*--------------------------------------*");
        System.out.println("[ 0 ] ZAKOŃCZ");
        do {
            choice = Main.inputHandler();
        } while (choice < 0 || choice > 9);
        return choice;
    }

    private void fieldManager(Farm farm) {
        System.out.println("[ 1 ] ZAKUP");
        System.out.println("[ 2 ] SPRZEDAŻ");
        int choice;
        do {
            choice = Main.inputHandler();
        } while (choice < 1 || choice > 2);
        if (choice % 2 == 1) {
            System.out.println("Zakup ziemi - cena wynosi " + Main.FIELD_PRICE + Main.CURRENCY + " za hektar.");
            System.out.println("Podaj ilość którą chcesz zakupić (dozwolone dodatnie liczby naturalne - 0 anuluje transakcję):");
            choice = 1;
            double bill = 0.0;
            do {
                if (choice < 0) System.out.println("Ilość mniejsza od zera. Jeszcze raz:");
                if (bill > account) System.out.println("Wartość zakupu (" + bill + Main.CURRENCY + ") przekracza stan konta (" + account + Main.CURRENCY + "). Zmniejsz rozmiar pola:");
                choice = Main.inputHandler();
                if (choice == 0) {
                    System.out.println("Transakcja anulowana.");
                    break;
                }
                bill = choice * Main.FIELD_PRICE;
            } while (choice < 0 || bill > account);
            if (choice > 0) {
                account -= bill;
                farm.addField(new Field(choice));
                System.out.println("Pole o rozmiarze " + choice + " ha zostało przypisane do Farmy.");
                System.out.println("Z konta została pobrana kwota " + bill + Main.CURRENCY + ". Stan konta po transakcji: " + account + Main.CURRENCY);
            }
        } else {
            System.out.println("Sprzedaż ziemi");
            //TODO("Continue...")
        }
    }
}
