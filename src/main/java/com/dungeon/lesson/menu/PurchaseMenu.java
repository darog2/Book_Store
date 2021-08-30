package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Purchase;
import com.dungeon.lesson.service.PurchaseService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class PurchaseMenu {
    private final PurchaseService purchaseService;
    private final Scanner scanner;

    public PurchaseMenu(Scanner scanner) {
        this.scanner = scanner;
        purchaseService = new PurchaseService(Configuration.getConnection());
    }

    public void startMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    purchaseService.printPurchases(purchaseService.getAllPurchases());
                }
                case 2 -> {
                    purchaseService.createPurchase();
                }
                case 3 -> {
                    purchaseService.deletePurchases();
                }
                case 4 -> {
                    searchMenu();
                }
                case 5->{
                    sortMenu();
                }

                case 99 -> {

                }

                default -> {
                    System.out.println("неправильная команда");
                }
            }
        }
        while (choice != 99);
    }

    private void printMenu() {
        System.out.println("действия с меню историей покупок ");
        System.out.println("1 показать  ");
        System.out.println("2 добавить  ");
        System.out.println("3 удалить  ");
        System.out.println("4 поиск ");
        System.out.println("5 сортировка ");
        System.out.println("99 вернутся в предыдущее меню. ");
    }

    private void printSearchMenu() {
        System.out.println("поиск по ");
        System.out.println("1 названию");
        System.out.println("2 имени покупателя");
        System.out.println("3 фамилии покупателя");
        System.out.println("4 стране");
        System.out.println("5 региону");
        System.out.println("6 городу");
        System.out.println("почтовому индексу");
        System.out.println("99 вернутся в предыдущее меню. ");
    }

    private void searchMenu() {
        int choice = 0;
        do {
            printSearchMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("найти по названию книги: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchPurchasesNames(name);
                    purchaseService.printPurchases(purchases);
                }
                case 2 -> {
                    System.out.println("поиск по имени покупателя: ");
                    scanner.nextLine();
                    String buyerName = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchBuyerNames(buyerName);
                    purchaseService.printPurchases(purchases);
                }
                case 3 -> {
                    System.out.println("поиск по фамилии: ");
                    scanner.nextLine();
                    String lastName = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchLastNames(lastName);
                    purchaseService.printPurchases(purchases);
                }
                case 4 -> {
                    System.out.println("поиск стране: ");
                    scanner.nextLine();
                    String country = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchCountry(country);
                    purchaseService.printPurchases(purchases);
                }
                case 5 -> {
                    System.out.println("поиск по региону: ");
                    scanner.nextLine();
                    String region = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchRegions(region);
                    purchaseService.printPurchases(purchases);
                }
                case 6 -> {
                    System.out.println("поиск по городу:  : ");
                    scanner.nextLine();
                    String locality = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchLocality(locality);
                    purchaseService.printPurchases(purchases);
                }
                case 7 -> {
                    System.out.println("поиск по почтовому индексу: ");
                    scanner.nextInt();
                    int zipCode = scanner.nextInt();
                    List<Purchase> purchases = purchaseService.searchZipCodes(zipCode);
                    purchaseService.printPurchases(purchases);
                }
                case 99 -> {

                }

                default -> {
                    System.out.println("неправильная команда");
                }
            }
        }
        while (choice != 99);
    }

    private void printSortMenu() {
        System.out.println("сортировать по ");
        System.out.println("1 названию книги");
        System.out.println("2 имени покупателя");
        System.out.println("3 фамилии покупателя");
        System.out.println("4 стране");
        System.out.println("5 региону");
        System.out.println("6 городу");
        System.out.println("7 почтовому индексу");
        System.out.println("99 вернутся в предыдущее меню. ");
    }

    private void sortMenu() {
        int choice = 0;
        do {
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 2 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getBuyerName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 3 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getLastName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 4 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getCountry);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 5 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getRegion);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 6 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getLocality);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 7 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getZipCode);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 99 -> {

                }

                default -> {
                    System.out.println("неправильная команда");
                }
            }
        }
        while (choice != 99);
    }
}




