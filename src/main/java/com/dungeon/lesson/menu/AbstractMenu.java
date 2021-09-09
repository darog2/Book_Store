package com.dungeon.lesson.menu;

import com.dungeon.lesson.service.AbstractService;

import java.util.Scanner;

public abstract class AbstractMenu {
//    protected final S service;
    private String header;
    protected final Scanner scanner;


    public AbstractMenu(Scanner scanner,String header) {
        this.header = header;
        this.scanner = scanner;
//        this.service= sClass.newInstance();
    }

    protected void printMenu() {
        System.out.println(header);
        System.out.println("1. показать все  ");
        System.out.println("2. добавить   ");
        System.out.println("3. удалить   ");
        System.out.println("4. поиск ");
        System.out.println("5. сортировка ");
        System.out.println("99 вернутся в предыдущее меню.");

    }
    public abstract void startMenu ();


    protected abstract void searchMenu();


    protected abstract void printSearchMenu();

    protected abstract void printSortMenu();

    protected abstract void sortMenu();

//    public void startMenu() {
//        int choice = 0;
//        do {
//            printMenu();
//            choice = scanner.nextInt();
//            switch (choice) {
//
//                case 1 -> {
//                    authorService.printAuthors(authorService.getAllAuthors());
//                }
//                case 2 -> {
//                    System.out.println(authorService.createAuthor());
//                }
//                case 3 -> {
//                    authorService.deleteAuthor();
//                }
//                case 4 -> {
//                    searchMenu();
//                }
//                case 5 -> {
//                    sortMenu();
//                }
//
//                case 99 -> {
//                }
//
//                default -> {
//                    System.out.println("неправильная команда");
//                }
//            }
//        }
//        while (choice != 99);
//    }
}
