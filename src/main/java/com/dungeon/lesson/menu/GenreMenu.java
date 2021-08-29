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
                case 3 -> {
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Genre> genres = genreService.searchByName(name);
                    genreService.printGenres(genres);
                }
                case 4 -> {
                    System.out.println("введите описание для поиска: ");
                    scanner.nextLine();
                    String description = scanner.nextLine();
                    List<Genre> genres = genreService.searchByDescription(description);
                    genreService.printGenres(genres);
                }
                case 5-> {
                    System.out.println("введите дату для поиска:");
                    int yearOfOriginal = scanner.nextInt();
                    List<Genre> genres = genreService.searchByYearOfOriginal(yearOfOriginal);
                    genreService.printGenres(genres);
                }
                case 6 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getName);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 7 -> {
                    Comparator<Genre> genreComparator = Comparator.comparing(Genre::getDescription);
                    List<Genre> genres = genreService.getAllGenres();
                    genres.sort(genreComparator);
                    genreService.printGenres(genres);
                }
                case 8 -> {
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

    private void printMenu() {
        System.out.println("1 показать все жанры: ");
        System.out.println("2 добавить жанр: ");
        System.out.println("3 поиск жанра по названию: ");
        System.out.println("4 поиск жанра по описанию: ");
        System.out.println("5 поиск жанра по году возникновения: ");
        System.out.println("6 сортировка по названию: ");
        System.out.println("7 сортировка по описанию: ");
        System.out.println("8 сортровка по году возникновения: ");
    }
}

