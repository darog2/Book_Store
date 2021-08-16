package com.dungeon.lesson.service;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsoleService {
    private BookService bookService;
    private AuthorService authorService;
    private Scanner scanner = new Scanner(System.in);
//    private void start(){

    public ConsoleService() {
        bookService = new BookService(Configuration.getConnection());
        authorService=new AuthorService(Configuration.getConnection());
    }

    //    }
    public void mainProcess() {

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
                case 99 -> {
                }
                case 4 -> {
                    System.out.print("введите название для поиска: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Book> books = bookService.searchBooks(name);
                    bookService.printBooks(books);

                }
                case 5->{
                    System.out.print("введите название  автора: ");
                    scanner.nextLine();
                    String author = scanner.nextLine();
                    List<Book> books = bookService.searchBooksByAuthor(author);
                    bookService.printBooks(books);
                }
                case 6->{
                    System.out.print("введите год книги: ");
                    int yearOfIssue = scanner.nextInt();
                    List<Book> books = bookService.searchBooksByYear(yearOfIssue);
                    bookService.printBooks(books);
                }
                case 7->{
                    Comparator<Book>bookComparator=Comparator.comparing(Book::getAuthor);
                    List<Book> books=bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 8->{
                    Comparator<Book>bookComparator=Comparator.comparing(Book::getName);
                    List<Book>books=bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 9->{
                    Comparator<Book>bookComparator=Comparator.comparing(Book::getYearOfIssue);
                    List<Book>books=bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 10->{
                    Comparator<Book>bookComparator=Comparator.comparing(Book::getPrice);
                    List<Book>books=bookService.getAllBooks();
                    books.sort(bookComparator);
                    bookService.printBooks(books);
                }
                case 11->{
                    authorService.printAuthors(authorService.getAllAuthors());
                }
                case 12 ->{
                    System.out.println(authorService.createAuthor());
                }
                case 13->{
                    System.out.print("введите имя: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByName(name);
                    authorService.printAuthors(authors);
                }
                case 14->{
                    System.out.print("введите фамилию: ");
                    scanner.nextLine();
                    String lastName= scanner.nextLine();
                    List<Author>authors= authorService.searchAuthorsByLastName(lastName);
                    authorService.printAuthors(authors);
                }
                case 15->{
                    System.out.print("введите год: ");
                    int dateOfBirth=scanner.nextInt();
                    List<Author>authors=authorService.searchAuthorsByDateOfBirth(dateOfBirth);
                    authorService.printAuthors(authors);
                }
                case 16->{
                    System.out.print("введите страну: ");
                    scanner.nextLine();
                    String country=scanner.nextLine();
                    List<Author>authors=authorService.searchAuthorsByCountry(country);
                    authorService.printAuthors(authors);
                }
                case 17->{
                    scanner.nextLine();
                    System.out.print("введите пол(M -- мужской, F -- женский):  ");
                    Gender gender= null;
                    String input;
                    do {

                        input = scanner.nextLine();
                        switch (input) {
                            case "F" -> {
                                gender = Gender.FEMALE;
                            }
                            case "M" -> {
                                gender = Gender.MALE;
                            }
                            default -> System.out.println("введите правельное значение: ");
                        }
                    }while (gender==null);
                    authorService.printAuthors(authorService.searchAuthorsByGender(gender));

                }
                case 18->{
                    Comparator<Author>authorComparator=Comparator.comparing(Author::getName);
                    List<Author>authors=authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);

                }
                case 19->{
                    Comparator<Author>authorComparator=Comparator.comparing(Author::getLastName);
                    List<Author>authors=authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 20->{
                    Comparator<Author>authorComparator=Comparator.comparing(Author::getDateOfBirth);
                    List<Author>authors=authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 21->{
                    Comparator<Author>authorComparator=Comparator.comparing(Author::getCountry);
                    List<Author>authors=authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 22->{
                    Comparator<Author>authorComparator=Comparator.comparing(Author::getGender);
                    List<Author>authors=authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }

                default -> {
                    System.out.println("неправильная команда");
                }
            }
        }
        while (choice != 99);


    }

    //    private void finish(){
//
//    }
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


        System.out.println("11. посмотреть авторов: ");
        System.out.println("12. добавить авторов: ");

        System.out.println("13 поиск авторов по имени: ");
        System.out.println("14 поиск авторов по фамили: ");
        System.out.println("15 поиск авторов по году рождения: ");
        System.out.println("16 поиск авторов по стране: ");
        System.out.println("17 поиск авторов по полу: ");
        System.out.println("18 сортировка по имени автора: ");
        System.out.println("19 сортировка по фамилии автора: ");
        System.out.println("20 сортировка по году: ");
        System.out.println("21 сортировка по стране: ");
        System.out.println("22 сортировка по полу: ");
        System.out.println("99. выйти из програмы  ");
        System.out.print("выберите действие: ");

    }

}
