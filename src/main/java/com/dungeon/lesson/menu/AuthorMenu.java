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
        this.scanner= scanner;
        authorService = new AuthorService(Configuration.getConnection());

    }
    public void startMenu(){
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
                System.out.print("введите имя: ");
                scanner.nextLine();
                String name = scanner.nextLine();
                List<Author> authors = authorService.searchAuthorsByName(name);
                authorService.printAuthors(authors);
            }
            case 4 -> {
                System.out.print("введите фамилию: ");
                scanner.nextLine();
                String lastName = scanner.nextLine();
                List<Author> authors = authorService.searchAuthorsByLastName(lastName);
                authorService.printAuthors(authors);
            }
            case 5 -> {
                System.out.print("введите год: ");
                int dateOfBirth = scanner.nextInt();
                List<Author> authors = authorService.searchAuthorsByDateOfBirth(dateOfBirth);
                authorService.printAuthors(authors);
            }
            case 6 -> {
                System.out.print("введите страну: ");
                scanner.nextLine();
                String country = scanner.nextLine();
                List<Author> authors = authorService.searchAuthorsByCountry(country);
                authorService.printAuthors(authors);
            }
                case 7 -> {
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
                case 8 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getName);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);

                }
                case 9 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getLastName);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 10 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getDateOfBirth);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 11 -> {
                    Comparator<Author> authorComparator = Comparator.comparing(Author::getCountry);
                    List<Author> authors = authorService.getAllAuthors();
                    authors.sort(authorComparator);
                    authorService.printAuthors(authors);
                }
                case 12 -> {
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

    private void printMenu() {
        System.out.println("1 посмотреть авторов ");
        System.out.println("2 добавить авторов ");
        System.out.println("3 поиск авторов по имени ");
        System.out.println("4 поиск авторов по фамили ");
        System.out.println("5 поиск авторов по году рождения ");
        System.out.println("6 поиск авторов по стране ");
        System.out.println("7 поиск авторов по полу ");
        System.out.println("8 сортировка по имени автора ");
        System.out.println("9 сортировка по фамилии автора ");
        System.out.println("10 сортировка по году ");
        System.out.println("11 сортировка по стране ");
        System.out.println("12 сортировка по полу ");
        System.out.println("99 вернутся в предыдущее меню. ");
    }
}
