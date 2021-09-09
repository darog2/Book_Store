package com.dungeon.lesson.menu;

import com.dungeon.lesson.Configuration;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.service.AuthorService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AuthorMenu extends AbstractMenu {
    private final AuthorService authorService;


    public AuthorMenu(Scanner scanner) {
        super(scanner, "меню работы с авторами");
        authorService = new AuthorService(Configuration.getConnection());

    }

    @Override
    public void startMenu() {
        int choice = 0;
        do {
            printMenu();
            choice = scanner.nextInt();
            switch (choice) {

                case 1 -> {
                    authorService.print(authorService.getAll());
                }
                case 2 -> {
                    System.out.println(authorService.create());
                }
                case 3 -> {
                    authorService.delete();
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

    @Override
    protected void printSearchMenu() {
        System.out.println("поиск по ");
        System.out.println("имени ");
        System.out.println(" фамилии");
        System.out.println("дате рождения");
        System.out.println(" стране ");
        System.out.println("полу");
        System.out.println("99 выйти в предыдущие меню");
    }

    @Override
    protected void searchMenu() {
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
                    authorService.print(authors);
                }
                case 2 -> {
                    System.out.print("введите фамилию: ");
                    scanner.nextLine();
                    String lastName = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByLastName(lastName);
                    authorService.print(authors);
                }
                case 3 -> {
                    System.out.print("введите год: ");
                    int dateOfBirth = scanner.nextInt();
                    List<Author> authors = authorService.searchAuthorsByDateOfBirth(dateOfBirth);
                    authorService.print(authors);
                }
                case 4 -> {
                    System.out.print("введите страну: ");
                    scanner.nextLine();
                    String country = scanner.nextLine();
                    List<Author> authors = authorService.searchAuthorsByCountry(country);
                    authorService.print(authors);
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
                    authorService.print(authorService.searchAuthorsByGender(gender));

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
    protected void printSortMenu() {
        System.out.println("сортировать по ");
        System.out.println("1 имени");
        System.out.println("2 фамилии");
        System.out.println("3 дате рождения");
        System.out.println("4 стране");
        System.out.println("5 полу");
        System.out.println("99 вернутся в предыдущее меню. ");

    }

    @Override
    protected void sortMenu() {
        int choice = 0;
        do {
            printSortMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getName);
                    List<Author> authors = authorService.getAll();
                    authors.sort(authorComparator);
                    authorService.print(authors);

                }
                case 2 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getLastName);
                    List<Author> authors = authorService.getAll();
                    authors.sort(authorComparator);
                    authorService.print(authors);
                }
                case 3 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getDateOfBirth);
                    List<Author> authors = authorService.getAll();
                    authors.sort(authorComparator);
                    authorService.print(authors);
                }
                case 4 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getCountry);
                    List<Author> authors = authorService.getAll();
                    authors.sort(authorComparator);
                    authorService.print(authors);
                }
                case 5 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getGender);
                    List<Author> authors = authorService.getAll();
                    authors.sort(authorComparator);
                    authorService.print(authors);
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






