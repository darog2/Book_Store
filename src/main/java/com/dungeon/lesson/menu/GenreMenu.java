package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.service.GenreService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GenreMenu {
    private final GenreService genreService;
    private final Scanner scanner;

    public GenreMenu(Scanner scanner) {
        this.scanner = scanner;
        genreService = new GenreService(Configuration.getConnection());
    }

    public void startMenu() {

        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    genreService.printGenres(genreService.getAllGenres());
                }
                case 2 -> {
                    System.out.println(genreService.createGenre());
                }
                case 3->{
                   genreService.deleteGenre();
                }
                case 4->{
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
        System.out.println("Меню работы с жанрами");
        System.out.println("1 показать все ");
        System.out.println("2 добавить  ");
        System.out.println("3 удалить  ");
        System.out.println("4 поиск ");
        System.out.println("5 сортировка ");
        System.out.println("99 вернутся в предыдущее меню. ");
    }

    private void printSearchMenu() {
        System.out.println("поиск по ");
        System.out.println(" 1 названию");
        System.out.println(" 2 описанию");
        System.out.println(" 3 году выпуска");
        System.out.println("99 вернутся в предыдущее меню.");
    }

    private void searchMenu() {

        int choice = 0;
        do {
            printSearchMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Genre> genres = genreService.searchByName(name);
                    genreService.printGenres(genres);
                }
                case 2 -> {
                    System.out.println("введите описание для поиска: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    List<Genre> genres = genreService.searchByDescription(description);
                    genreService.printGenres(genres);
                }
                case 3 -> {
                    System.out.println("введите дату для поиска:");
                    int yearOfOriginal = scanner.nextInt();
                    List<Genre> genres = genreService.searchByYearOfOriginal(yearOfOriginal);
                    genreService.printGenres(genres);
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
     private void printSortMenu(){
         System.out.println("сортировать по ");
         System.out.println(" 1 названию");
         System.out.println(" 2 описанию");
         System.out.println(" 3 году выпуска");
         System.out.println("99 вернутся в предыдущее меню.");
     }
    private void sortMenu() {

        int choice = 0;
        do {
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getName);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 2 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getDescription);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 3 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getYearOfOrigin);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
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

