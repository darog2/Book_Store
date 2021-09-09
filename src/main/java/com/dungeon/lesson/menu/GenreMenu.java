package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.service.GenreService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class GenreMenu extends AbstractMenu {
    private final GenreService genreService;


    public GenreMenu(Scanner scanner) {
        super(scanner,"Меню работы с жанрами");
        genreService = new GenreService(Configuration.getConnection());
    }
@Override
    public void startMenu() {

        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    genreService.print(genreService.getAll());
                }
                case 2 -> {
                    System.out.println(genreService.create());
                }
                case 3->{
                    genreService.delete();
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
    @Override
    protected  void printSearchMenu() {
        System.out.println("поиск по ");
        System.out.println(" 1 названию");
        System.out.println(" 2 описанию");
        System.out.println(" 3 году выпуска");
        System.out.println("99 вернутся в предыдущее меню.");
    }
    @Override
    protected void searchMenu() {

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
                    genreService.print(genres);
                }
                case 2 -> {
                    System.out.println("введите описание для поиска: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    List<Genre> genres = genreService.searchByDescription(description);
                    genreService.print(genres);
                }
                case 3 -> {
                    System.out.println("введите дату для поиска:");
                    int yearOfOriginal = scanner.nextInt();
                    List<Genre> genres = genreService.searchByYearOfOriginal(yearOfOriginal);
                    genreService.print(genres);
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
    @Override
     protected void printSortMenu(){
         System.out.println("сортировать по ");
         System.out.println(" 1 названию");
         System.out.println(" 2 описанию");
         System.out.println(" 3 году выпуска");
         System.out.println("99 вернутся в предыдущее меню.");
     }
    @Override
    protected void sortMenu() {

        int choice = 0;
        do {
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getName);
                    List<Genre> genres = genreService.getAll();
                    genres.sort(genreComparator);
                    genreService.print(genres);
                }
                case 2 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getDescription);
                    List<Genre> genres = genreService.getAll();
                    genres.sort(genreComparator);
                    genreService.print(genres);
                }
                case 3 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getYearOfOrigin);
                    List<Genre> genres = genreService.getAll();
                    genres.sort(genreComparator);
                    genreService.print(genres);
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

