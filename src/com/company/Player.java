package com.company;

import com.company.buildings.Building;
import com.company.buildings.Field;

import java.util.List;

public class Player {
    private Farm farm;
    private Double account;
    private Market market;

    public Player(Farm farm, Market market) {
        this.farm = farm;
        this.account = Main.STARTING_MONEY;
        this.market = market;
    }

    public void accountDeposit(double amount) {
        this.account += amount;
    }

    public boolean accountWithdraw(double amount) {
        if (this.account >= amount) {
            this.account -= amount;
            return true;
        } else return false;
    }

    public void play() {
        boolean looper = true;
        while (looper) {
            market.freeMarket();
            serviceWorker();
            switch (actionMenu()) {
                case 1 -> fieldManager(farm);
                case 2 -> buildingManager(farm);
                case 3 -> animalManager(farm);
                case 6 -> System.out.println("--- STAN FARMY ---\n" + farm);
                case 0 -> looper = false;
            }
        }
    }

    private void serviceWorker() {
        for (int i = 0; i < farm.getNoOfFields(); i++) {
            farm.getField(i).weeklyTasks();
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
            if (choice < 0 || choice > 9) System.out.println("*** POZA ZAKRESEM *** [0-9]");
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
                if (bill > account)
                    System.out.println("Wartość zakupu (" + bill + Main.CURRENCY + ") przekracza stan konta (" + account + Main.CURRENCY + "). Zmniejsz rozmiar pola:");
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
            System.out.println("Sprzedaż ziemi - dostępne do sprzedaży:");
            for (int i = 0; i < farm.getNoOfFields(); i++) {
                System.out.println("[" + (i + 1) + "] " + farm.getField(i) + "; kwota sprzedaży: " + (farm.getField(i).getSize() * Main.FIELD_PRICE) + Main.CURRENCY);
            }
            System.out.println("Podaj numer farmy do sprzedania (lub 0, aby anulować transakcję):");
            do {
                choice = Main.inputHandler();
                if (choice == 0) {
                    System.out.println("Transakcja anulowana.");
                    break;
                }
                double cash = (farm.getField(choice - 1).getSize() * Main.FIELD_PRICE);
                account += cash;
                farm.removeField(choice - 1);
                System.out.println("Pole zostało sprzedane za " + cash + Main.CURRENCY + ", stan konta po transakcji: " + account + Main.CURRENCY);
            } while (choice < 0 || choice > farm.getNoOfFields());
        }
    }

    private void buildingManager(Farm farm) {
        System.out.println("[ 1 ] ZAKUP STODOŁY");
        System.out.println("[ 2 ] ZAKUP KURNIKA");
        System.out.println("[ 3 ] ZAKUP OBORY");
        System.out.println("[ 4 ] ZAKUP OWCZARNI");
        System.out.println("[ 5 ] ZAKUP CHLEWU");
        System.out.println("[ 6 ] ZAKUP STAJNI");
        System.out.println("[ 7 ] SPRZEDAŻ");
        int choice;
        do {
            choice = Main.inputHandler();
        } while (choice < 1 || choice > 7);
        if (choice != 7) {
            double buildingPrice = (choice == 1) ? Main.STORAGE_BUILD_PRICE : Main.ANIMAL_BUILD_PRICE;
            System.out.println("Zakup budynku - cena wynosi " + buildingPrice + Main.CURRENCY + " za jednostkę pojemności.");
            System.out.println("Podaj ilość którą chcesz zakupić (dozwolone dodatnie liczby naturalne - 0 anuluje transakcję):");
            choice = 1;
            double bill = 0.0;
            do {
                if (choice < 0) System.out.println("Ilość mniejsza od zera. Jeszcze raz:");
                if (bill > account)
                    System.out.println("Wartość zakupu (" + bill + Main.CURRENCY + ") przekracza stan konta (" + account + Main.CURRENCY + "). Zmniejsz pojemność:");
                choice = Main.inputHandler();
                if (choice == 0) {
                    System.out.println("Transakcja anulowana.");
                    break;
                }
                bill = choice * buildingPrice;
            } while (choice < 0 || bill > account);
            if (choice > 0) {
                account -= bill;
                farm.addField(new Field(choice));
                System.out.println("Budynek o pojemności " + choice + " został przypisany do Farmy.");
                System.out.println("Z konta została pobrana kwota " + bill + Main.CURRENCY + ". Stan konta po transakcji: " + account + Main.CURRENCY);
            }
        } else {
            System.out.println("Sprzedaż budynków - dostępne do sprzedaży:");
            for (int i = 0; i < farm.getNoOfBuildings(); i++) {
                double buildingPrice = (farm.getBuilding(i).getClass().getSimpleName().equals("Barn")) ? Main.STORAGE_BUILD_PRICE : Main.ANIMAL_BUILD_PRICE;
                System.out.println("[" + (i + 1) + "] " + farm.getBuilding(i) + "; kwota sprzedaży: " + (farm.getBuilding(i).getSize() * buildingPrice) + Main.CURRENCY);
            }
            System.out.println("Zwierzęta lub towary przypisane do budynku zostaną automatycznie sprzedane z karą 10%.");
            System.out.println("Podaj numer budynku do sprzedania (lub 0, aby anulować transakcję):");
            do {
                choice = Main.inputHandler();
                if (choice == 0) {
                    System.out.println("Transakcja anulowana.");
                    break;
                }
                Double cash = (farm.getBuilding(choice - 1).autoSell(market));
                account += cash;
                farm.removeBuilding(choice - 1);
                System.out.println("Budynek z zawartością został sprzedany za " + cash + Main.CURRENCY + ", stan konta po transakcji: " + account + Main.CURRENCY);
            } while (choice < 0 || choice > farm.getNoOfBuildings());
        }
    }

    private void animalManager(Farm farm) {
        System.out.println("[ 1 ] ZAKUP/SPRZEDAŻ KUR");
        System.out.println("[ 2 ] ZAKUP/SPRZEDAŻ KRÓW");
        System.out.println("[ 3 ] ZAKUP/SPRZEDAŻ OWIEC");
        System.out.println("[ 4 ] ZAKUP/SPRZEDAŻ ŚWIŃ");
        System.out.println("[ 5 ] ZAKUP/SPRZEDAŻ KONI");
        int choice;
        do {
            choice = Main.inputHandler();
        } while (choice < 1 || choice > 5);
        List<Building> availableBuildings;
        switch (choice) {
            case 1 -> availableBuildings = farm.listBuildings("Chickencoop");
            case 2 -> availableBuildings = farm.listBuildings("Cowshed");
            case 3 -> availableBuildings = farm.listBuildings("Fold");
            case 4 -> availableBuildings = farm.listBuildings("Pigpen");
            case 5 -> availableBuildings = farm.listBuildings("Stable");
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        }
        System.out.println("Wybierz budynek w którym chcesz dokonać zmiany:");
        for (int i = 0; i < availableBuildings.size(); i++) {
            System.out.println("[ " + (i + 1) + " ] Liczba zwierząt: " + availableBuildings.get(i).getAmount());
        }
        do {
            choice = Main.inputHandler();
        } while (choice < 0 || choice > availableBuildings.size());
        Building selectedBuilding = availableBuildings.get(choice);
        System.out.println("Podaj liczbę zwierząt do kupienia/sprzedaży (dodatnia - zakup / ujemna - sprzedaż / 0 - anuluj):");
        boolean looper = true;
        do {
            do {
                choice = Main.inputHandler();
                if (choice == 0) return;
            } while (choice == Integer.MIN_VALUE);
            int maxSell = selectedBuilding.getAmount();
            int maxBuy = selectedBuilding.getSize() - selectedBuilding.getAmount();
            if (choice > 0) {   // BUY
                double bill = selectedBuilding.getBuySellPrice(choice, market);
                if (choice > maxBuy) {
                    System.out.println("Niewystarczająca liczba wolnych miejsc w budynku.");
                } else if (bill > account) {
                    System.out.println("Wartość zakupu (" + bill + Main.CURRENCY + ") przekracza stan konta (" + account + Main.CURRENCY + ").");
                } else {
                    account -= bill;
                    selectedBuilding.changeAnimalAmount(choice);
                    System.out.println("Zakupiono " + choice + " zwierząt za kwotę " + bill + Main.CURRENCY + ". Stan konta: " + account + Main.CURRENCY);
                    looper = false;
                }
            } else {    // SELL
                choice *= -1;
                if (choice > maxSell) {
                    System.out.println("Liczba zwierząt do sprzedania jest mniejsza od żądanej.");
                } else {
                    double bill = selectedBuilding.getBuySellPrice(choice, market);
                    account += bill;
                    selectedBuilding.changeAnimalAmount(choice * -1);
                    System.out.println("Sprzedano " + choice + " zwierząt za kwotę " + bill + Main.CURRENCY + ". Stan konta: " + account + Main.CURRENCY);
                    looper = false;
                }
            }
        } while (looper);
    }
}
