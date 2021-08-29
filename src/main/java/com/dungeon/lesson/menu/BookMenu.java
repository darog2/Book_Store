package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.model.Genre;
import com.dungeon.lesson.model.Purchase;
import com.dungeon.lesson.service.BookService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class BookMenu {
    private final BookService bookService;
    private final Scanner scanner;


    public BookMenu(Scanner scanner) {
        this.scanner = scanner;
        bookService = new BookService(Configuration.getConnection());
    }
    public void startMenu(){
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
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Book> books = bookService.searchBooks(name);
                    bookService.printBooks(books);

                }
                case 5 -> {
                    System.out.print("введите название  автора: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByAuthor(author);
                    bookService.printBooks(books);
                }
                case 6 -> {
                    System.out.print("введите год книги: ");
                    int yearOfIssue = scanner.nextInt();
                    List<Book> books = bookService.searchBooksByYear(yearOfIssue);
                    bookService.printBooks(books);
                }
                case 7 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getAuthor);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 8 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getName);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 9 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getYearOfIssue);
                    List<Book> books = bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 10 -> {
                    Comparator<Book> bookComparator = Comparator.comparing(Book::getPrice);
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

    private void printMenu() {
        System.out.println("1. показать все книги ");
        System.out.println("2. добавить книгу  ");
        System.out.println("3. удалить книгу  ");
        System.out.println("4. найти книгу по названию: ");
        System.out.println("5. найти книгу по автору: ");
        System.out.println("6. поиск по году: ");
        System.out.println("7. сортировка по автору");
        System.out.println("8. сортировка по названию");
        System.out.println("9. сортировка по году выпуска");
        System.out.println("10. сортировка по цене");
        System.out.println("99 вернутся в главное меню.");
    }
}
