package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.service.AuthorService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AuthorMenu {
    private final AuthorService authorService;
    private final Scanner scanner;

    public AuthorMenu(Scanner scanner) {
        this.scanner = scanner;
        authorService = new AuthorService(Configuration.getConnection());

    }

    public void startMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    authorService.printAuthors(authorService.getAllAuthors());
                }
                case 2 -> {
                    System.out.println(authorService.createAuthor());
                }
                case 3 -> {
                    authorService.deleteAuthor();
                }
                case 4 -> {
                    searchMenu();
                }
                case 5 ->{
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

    private void printMenu() {
        System.out.println("меню работы с авторами");
        System.out.println("1 посмотреть ");
        System.out.println("2 добавить  ");
        System.out.println("3 удалить");
        System.out.println("4 поиск поиск ");
        System.out.println("5 сортировка");

        System.out.println("99 вернутся в предыдущее меню. ");
    }

    private void printSearchMenu() {
        System.out.println("поиск по ");
        System.out.println("имени ");
        System.out.println(" фамилии");
        System.out.println("дате рождения");
        System.out.println(" стране ");
        System.out.println("полу");
        System.out.println("99 выйти в предыдущие меню");
    }

    private void searchMenu() {
        int choice = 0;
        do {
            printSearchMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("введите имя: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByName(name);
                    authorService.printAuthors(authors);
                }
                case 2 -> {
                    System.out.print("введите фамилию: ");
                    scanner.nextLine();
                    String lastName = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByLastName(lastName);
                    authorService.printAuthors(authors);
                }
                case 3 -> {
                    System.out.print("введите год: ");
                    int dateOfBirth = scanner.nextInt();
                    List<Author> authors = authorService.searchAuthorsByDateOfBirth(dateOfBirth);
                    authorService.printAuthors(authors);
                }
                case 4 -> {
                    System.out.print("введите страну: ");
                    scanner.nextLine();
                    String country = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByCountry(country);
                    authorService.printAuthors(authors);
                }
                case 5 -> {
                    scanner.nextLine();
                    System.out.print("введите пол(M -- мужской, F -- женский):  ");
                    Gender gender = null;
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
                    } while (gender == null);
                    authorService.printAuthors(authorService.searchAuthorsByGender(gender));

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

    private void printSortMenu() {
        System.out.println("сортировать по ");
        System.out.println("1 имени");
        System.out.println("2 фамилии");
        System.out.println("3 дате рождения");
        System.out.println("4 стране");
        System.out.println("5 полу");
        System.out.println("99 вернутся в предыдущее меню. ");

    }

    private void sortMenu() {
        int choice = 0;
        do {
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getName);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);

                }
                case 2 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getLastName);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 3 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getDateOfBirth);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 4 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getCountry);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 5 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getGender);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
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






