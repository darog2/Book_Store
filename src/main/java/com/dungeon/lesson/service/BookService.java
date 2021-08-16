package com.dungeon.lesson.service;

import com.dungeon.lesson.dao.BookDao;
import com.dungeon.lesson.model.Book;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    /*
    методы бук сервиса:
    - getAllBooks будет возвращать List <Book>
    - addBook будет добавлять книги и принимает на вход ему нужна книга
    - deleteBook будет удалять книги

     */
    public static final String BORDER = "-------------------------------------------------------------------------" + System.lineSeparator();
    public static final String HEADER = "|  №  |          название            |         автор   | год  |   цена  |" + System.lineSeparator();
    public static final String BOOK_FORMAT = "|%4d | %-28.28s | %-15.15s | %4d |  %6.2f |%n";

    private final Connection connection;
    private final BookDao bookDao;
    private final Scanner scanner = new Scanner(System.in);

    public BookService(Connection connection) {
        this.connection = connection;
        bookDao = new BookDao(connection);
    }

    private void saveBook(Book book) {
        try {
            bookDao.saveBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(Book book) {
        try {
            bookDao.deleteBook(book);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new LinkedList<>();
        try {
            return bookDao.getAllBooks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book createBook() {
        Book book = new Book();
        System.out.print("введите автора: ");
        book.setAuthor(scanner.nextLine());
        System.out.print("введите название книги:  ");
        book.setName(scanner.nextLine());
        System.out.print("введите год выпуска: ");
        book.setYearOfIssue(scanner.nextInt());
        System.out.print("введите цену: ");
        book.setPrice(scanner.nextDouble());
        saveBook(book);
        return book;
    }

    public void deleteBook() {
        List<Book> books = getAllBooks();
        printBooks(books);
        System.out.println("выберите номер книги для удаления: ");
        boolean isCorrect = false;
        do {
            int delete = scanner.nextInt();
            if (delete > 0 && delete <= books.size()) {
                Book book = books.get(delete - 1);
                deleteBook(book);
                isCorrect = true;
            } else {
                System.out.println("введите существующий номер: ");
            }
        } while (!isCorrect);
        System.out.println("книга удалена ");
    }

    public void printBooks(List<Book> books) {
        if (books.size()>0){
            StringBuilder builder = new StringBuilder();
            builder.append(BORDER);
            builder.append(HEADER);
            builder.append(BORDER);
            for (Book book : books) {
                builder.append(
                        BOOK_FORMAT.formatted(
                                book.getId(),
                                book.getName(),
                                book.getAuthor(),
                                book.getYearOfIssue(),
                                book.getPrice()));
            }
//        builder.append("|  2  |  451 по фаренгейту           | Рей бредбери    |      43.11|");
            builder.append(BORDER);
            System.out.println(builder);
        }else {
            System.out.println("книги не найдены ");
        }
    }

    public List<Book> searchBooks(String name){
        List<Book> books = new LinkedList<>();
        try {
            return bookDao.searchBooks( name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;

    }
       public List<Book> searchBooksByAuthor(String author) {
        List<Book> books = new LinkedList<>();
        try {
            return bookDao.searchBooksByAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
    public List<Book> searchBooksByYear(int yearOfIssue ) {
        List<Book> books = new LinkedList<>();
        try {
            return bookDao.searchBooksByYear(yearOfIssue );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }



}

