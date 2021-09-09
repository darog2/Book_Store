package com.dungeon.lesson.service;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.menu.AuthorMenu;
import com.dungeon.lesson.menu.BookMenu;
import com.dungeon.lesson.menu.GenreMenu;
import com.dungeon.lesson.menu.PurchaseMenu;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.model.Purchase;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainMenuService {


    private Scanner scanner = new Scanner(System.in);
    private final BookMenu bookMenu;
    private final AuthorMenu authorMenu;
    private final GenreMenu genreMenu;
    private final PurchaseMenu purchaseMenu;
//    private void start(){

    public MainMenuService() {
        bookMenu = new BookMenu(scanner);
        authorMenu = new AuthorMenu();
        purchaseMenu = new PurchaseMenu();
        genreMenu = new GenreMenu();
//        genreMenu = new GenreMenu(scanner);
//        authorMenu = new AuthorMenu(scanner);
//        purchaseMenu = new PurchaseMenu(scanner);
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
                case 2 -> {
                    authorMenu.startMenu();
                }
                case 3 -> {
                    genreMenu.startMenu();
                }
                case 4 -> {
                    purchaseMenu.startMenu();
                }
                case 99->{

                }
                default -> {
                    System.out.println("неправильная команда");
                }
            }
        }
        while (choice != 99);
    }

            private void printMenu () {
                System.out.println("1 действия с книгами: ");
                System.out.println("2 действия с авторами: ");
                System.out.println("3 действия с жанрами: ");
                System.out.println("4 действия с историей покупок: ");


                System.out.println("99. выйти из програмы  ");
                System.out.print("выберите действие: ");

            }


    }
