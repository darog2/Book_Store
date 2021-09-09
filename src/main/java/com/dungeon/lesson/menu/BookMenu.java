package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class BookMenu extends AbstractMenu<BookService> {
    private final BookService bookService;
    private static final String SORT_BY = " сортировка по  ";
    private static final String SEARCH_BY = " поиск по  ";



    public BookMenu(Scanner scanner) {
        super(scanner, BookService.class," Меню работы с книгами ");

        bookService = new BookService(Configuration.getConnection());
    }

//    @Override
//    public void startMenu() {
//        int choice = 0;
//        do {
//            printMenu();
//            choice = scanner.nextInt();
//            switch (choice) {
//                case 1 -> {
//                    bookService.print(bookService.getAll());
//                }
//                case 2 -> {
//                    System.out.println(bookService.create());
//                }
//                case 3 -> {
//                    bookService.delete();
//                }
//                case 4 -> {
//                    searchMenu();
//                }
//
//                case 5 -> {
//                    sortMenu();
//                }
////                case 10 -> {
////                    Comparator<Book> bookComparator = Comparator.comparing(Book::getPrice);
////                    List<Book> books = bookService.getAllBooks();
////                    books.sort(bookComparator);
////                    bookService.printBooks(books);
////                }
//                case 99 -> {
//                }
//
//
//                default -> {
//                    System.out.println("неправильная команда");
//                }
//            }
//        }
//        while (choice != 99);
//
//    }

    @Override
    protected void searchMenu() {
        int choice = 0;
        do {
            printFieldsMenu(SEARCH_BY);
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Book> books = bookService.searchBooks(name);
                    bookService.print(books);

                }
                case 2 -> {
                    System.out.print("введите название  автора: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByAuthor(author);
                    bookService.print(books);
                }
                case 3 -> {
                    System.out.print("введите год книги: ");
                    int yearOfIssue = scanner.nextInt();
                    List<Book> books = bookService.searchBooksByYear(yearOfIssue);
                    bookService.print(books);
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
    protected void printFieldsMenu(String mode) {
        System.out.println(mode);
        System.out.println("1. названию   ");
        System.out.println("2. автору   ");
        System.out.println("3. году выпуска  ");
        System.out.println("4. цене");

        System.out.println("99 вернутся в предыдущее меню.");
    }


    @Override
    protected void sortMenu() {
        int choice = 0;
        do {
            printFieldsMenu(SORT_BY);
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getAuthor);
                    List<Book> books = bookService.getAll();
                    books.sort(bookComparator);
                    bookService.print(books);
                }
                case 2 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getName);
                    List<Book> books = bookService.getAll();
                    books.sort(bookComparator);
                    bookService.print(books);
                }
                case 3 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getYearOfIssue);
                    List<Book> books = bookService.getAll();
                    books.sort(bookComparator);
                    bookService.print(books);
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
