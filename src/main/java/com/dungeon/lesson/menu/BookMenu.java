package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class BookMenu extends AbstractMenu {
    private final BookService bookService;



    public BookMenu(Scanner scanner) {
        super(scanner, " Меню работы с книгами ");

        bookService = new BookService(Configuration.getConnection());
    }

    @Override
    public void startMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    bookService.printBooks(bookService.getAllBooks());
                }
                case 2 -> {
                    System.out.println(bookService.createBook());
                }
                case 3 -> {
                    bookService.deleteBook();
                }
                case 4 -> {
                    searchMenu();
                }

                case 5 -> {
                    sortMenu();
                }
//                case 10 -> {
//                    Comparator<Book> bookComparator = Comparator.comparing(Book::getPrice);
//                    List<Book> books = bookService.getAllBooks();
//                    books.sort(bookComparator);
//                    bookService.printBooks(books);
//                }
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
                    List<Book> books = bookService.searchBooks(name);
                    bookService.printBooks(books);

                }
                case 2 -> {
                    System.out.print("введите название  автора: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByAuthor(author);
                    bookService.printBooks(books);
                }
                case 3 -> {
                    System.out.print("введите год книги: ");
                    int yearOfIssue = scanner.nextInt();
                    List<Book> books = bookService.searchBooksByYear(yearOfIssue);
                    bookService.printBooks(books);
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
    protected void printSearchMenu() {
        System.out.println(" поиск по  ");
        System.out.println("1. названию   ");
        System.out.println("2. автору   ");
        System.out.println("3. году выпуска  ");
        System.out.println("4. цене");

        System.out.println("99 вернутся в предыдущее меню.");
    }

    @Override
    protected void printSortMenu() {
        System.out.println(" сортировка по  ");
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
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getAuthor);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 2 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getName);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 3 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getYearOfIssue);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
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
