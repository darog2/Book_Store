package com.dungeon.lesson.service;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.menu.AuthorMenu;
import com.dungeon.lesson.menu.BookMenu;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.model.Purchase;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainMenuService {

    private PurchaseService purchaseService;
    private GenreService genreService;
    private Scanner scanner = new Scanner(System.in);
    private final BookMenu bookMenu;
    private final AuthorMenu authorMenu;
//    private void start(){

    public MainMenuService() {
       bookMenu= new BookMenu(scanner);
       authorMenu= new AuthorMenu(scanner);
        purchaseService = new PurchaseService(Configuration.getConnection());
        genreService=new GenreService(Configuration.getConnection());
    }

    //    }
    public void mainProcess() {

        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
               case 1 -> {
                   bookMenu.startMenu();
               }
               case 2->{
                   authorMenu.startMenu();
               }


                case 23 -> {
                    genreService.printGenres(genreService.getAllGenres());
                }
                case 24 -> {
                    System.out.println(genreService.createGenre());
                }
                case 25 -> {
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Genre> genres = genreService.searchByName(name);
                    genreService.printGenres(genres);
                }
                case 26 -> {
                    System.out.println("введите описание для поиска: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    List<Genre> genres = genreService.searchByDescription(description);
                    genreService.printGenres(genres);
                }
                case 27 -> {
                    System.out.println("введите дату для поиска:");
                    int yearOfOriginal = scanner.nextInt();
                    List<Genre> genres = genreService.searchByYearOfOriginal(yearOfOriginal);
                    genreService.printGenres(genres);
                }
                case 28 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getName);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 29 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getDescription);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 30 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getYearOfOrigin);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 31 -> {
                    purchaseService.printPurchases(purchaseService.getAllPurchases());
                }
                case 32 -> {
                    System.out.println("найти по названию книги: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchPurchasesNames(name);
                    purchaseService.printPurchases(purchases);
                }
                case 33 -> {
                    System.out.println("поиск по имени покупателя: ");
                    scanner.nextLine();
                    String buyerName = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchBuyerNames(buyerName);
                    purchaseService.printPurchases(purchases);
                }
                case 34 -> {
                    System.out.println("поиск по фамилии: ");
                    scanner.nextLine();
                    String lastName = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchLastNames(lastName);
                    purchaseService.printPurchases(purchases);
                }
                case 35 -> {
                    System.out.println("поиск стране: ");
                    scanner.nextLine();
                    String country = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchCountry(country);
                    purchaseService.printPurchases(purchases);
                }
                case 36 -> {
                    System.out.println("поиск по региону: ");
                    scanner.nextLine();
                    String region = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchRegions(region);
                    purchaseService.printPurchases(purchases);
                }
                case 37 -> {
                    System.out.println("поиск по городу:  : ");
                    scanner.nextLine();
                    String locality = scanner.nextLine();
                    List<Purchase> purchases = purchaseService.searchLocality(locality);
                    purchaseService.printPurchases(purchases);
                }
                case 38 -> {
                    System.out.println("поиск по почтовому индексу: ");
                    scanner.nextInt();
                    int zipCode = scanner.nextInt();
                    List<Purchase> purchases = purchaseService.searchZipCodes(zipCode);
                    purchaseService.printPurchases(purchases);
                }
                case 39 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 40 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getBuyerName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 41 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getLastName);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 42 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getCountry);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 43 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getRegion);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 44 -> {
                    Comparator<Purchase> purchaseComparator = Comparator.comparing(Purchase::getLocality);
                    List<Purchase> purchases = purchaseService.getAllPurchases();
                    purchases.sort(purchaseComparator);
                    purchaseService.printPurchases(purchases);
                }
                case 45 -> {
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

    //    private void finish(){
//
//    }
    private void printMenu() {
        System.out.println("1 действия с книгами: ");
        System.out.println("2 действия с авторами: ");


        System.out.println("23 показать все жанры: ");
        System.out.println("24 добавить жанр: ");
        System.out.println("25 поиск жанра по названию: ");
        System.out.println("26 поиск жанра по описанию: ");
        System.out.println("27 поиск жанра по году возникновения: ");
        System.out.println("28 сортировка по названию: ");
        System.out.println("29 сортировка по описанию: ");
        System.out.println("30 сортровка по году возникновения: ");
        System.out.println("31 показать историю покупки: ");
        System.out.println("32 поиск по названи книги: ");
        System.out.println("33 поиск по имени : ");
        System.out.println("34 поиск по фамилии: ");
        System.out.println("35 поиск по стране: ");
        System.out.println("36 поиск по региону: ");
        System.out.println("37 поиск по городу: ");
        System.out.println("38 поиск по почтовому индексу: ");

        System.out.println("39 сортировать по названию книги: ");
        System.out.println("40 сортировать по имени покупателя: ");
        System.out.println("41 сортировать по фамилии: ");
        System.out.println("42 сортировать по стране: ");
        System.out.println("43 сортировать по региону: ");
        System.out.println("44 сортировать по городу: ");
        System.out.println("45 сортировать по почтовому адресу: ");

        System.out.println("99. выйти из програмы  ");
        System.out.print("выберите действие: ");

    }

}
