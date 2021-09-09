package com.dungeon.lesson.menu;

import com.dungeon.lesson.service.AbstractService;

import java.util.Scanner;

public abstract class AbstractMenu<SERVICE extends AbstractService> {
    protected final SERVICE service;
    private String header;
    protected final Scanner scanner;


    public AbstractMenu(Scanner scanner, Class<SERVICE> serviceClass, String header) {
        this.header = header;
        this.scanner = scanner;
        try {
            this.service= serviceClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
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
//    public abstract void startMenu ();


    protected abstract void searchMenu();

    protected abstract void printFieldsMenu(String mode);

    protected abstract void sortMenu();

    public void startMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    service.print(service.getAll());
                }
                case 2 -> {
                    System.out.println(service.create());
                }
                case 3 -> {
                    service.delete();
                }
                case 4 -> {
                    searchMenu();
                }
                case 5 -> {
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
}
