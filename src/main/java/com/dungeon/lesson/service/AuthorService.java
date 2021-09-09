package com.dungeon.lesson.service;

import com.dungeon.lesson.dao.AuthorDao;
import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.util.DateFormatUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AuthorService extends AbstractService<Author> {

    public static final String BORDER = "--------------------------------------------------------------------------------------"+System.lineSeparator();
    public static final String HEADER = "| id |      имя     |     фамилия     |    дата рождения   |    страна   |    пол    |"+System.lineSeparator();
    public static final String AUTHOR_FORMAT = "| %3d  | %-15s | %-16s | %-14s | %-12s | %6s |%n";
    private final AuthorDao authorDao;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorService(Connection connection) {
        authorDao = new AuthorDao(connection);
    }
@Override
    public List<Author> getAll() {
        List<Author> authors = new LinkedList<>();
        try {
            return authorDao.getAllAuthors();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;

    }
    @Override
    protected void save(Author author) {
        try {
            authorDao.saveAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Author create() {
        Author author = new Author();
        System.out.print("введите имя : ");
        author.setName(scanner.nextLine());
        System.out.print("введите фамилию :  ");
        author.setLastName(scanner.nextLine());
        System.out.print("введите дату рождения(dd-mm-yyyy): ");
        try {
            author.setDateOfBirth(DateFormatUtil.ONLY_DATE.parse(scanner.nextLine()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.print("введите страну: ");
        author.setCountry(scanner.nextLine());
        System.out.print("введите пол(M -- мужской, F -- женский):  ");
        Gender gender= null;
        String input;
        do {
            input=scanner.nextLine();
            switch (input) {
                case "F" -> {
                    author.setGender(Gender.FEMALE);
                }
                case "M" -> {
                    author.setGender(Gender.MALE);

                }
                default -> System.out.print("введите правельное значение: ");
            }
        }while (author.getGender()==null);

        save(author);
        return author;
    }
    @Override
    protected void delete(Author author) {
        try {
            authorDao.deleteAuthor(author);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void delete() {
        List<Author> authors = getAll();
        print(authors);
        System.out.println("выберите автора для удаления: ");
        boolean isCorrect = false;
        do {
            int delete = scanner.nextInt();
            if (delete > 0 && delete <= authors.size()) {
                Author author= authors.get(delete - 1);
                delete(author);
                isCorrect = true;
            } else {
                System.out.println("введите существующий номер: ");
            }
        } while (!isCorrect);
        System.out.println("книга удалена ");
    }
    @Override
    public void print(List<Author> authors) {
        if (authors.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(BORDER);
            builder.append(HEADER);
            builder.append(BORDER);
            for(Author author:authors) {
                builder.append(AUTHOR_FORMAT.formatted(author.getId(),
                        author.getName(),
                        author.getLastName(),
                        author.getDateOfBirth(),
                        author.getCountry(),
                        author.getGender()));

            }
            builder.append(BORDER);
            System.out.println(builder.toString());
        }else{
            System.out.println("авторы не найдены ");
        }
    }
    public List<Author>searchAuthorsByName(String name) {
        List<Author> authors = new LinkedList<>();
        try {
            return authorDao. searchAuthorsByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authors;
    }
    public List<Author> searchAuthorsByLastName(String lastName){
        List<Author>authors = new LinkedList<>();
        try{
            return authorDao.searchAuthorsByLastName(lastName);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;
    }
    public List<Author>searchAuthorsByDateOfBirth (int dateOfBirth){
        List<Author>authors = new LinkedList<>();
        try{
            return authorDao.searchAuthorsByDateOfBirth(dateOfBirth);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;
    }
    public List<Author>searchAuthorsByCountry (String country){
        List<Author>authors = new LinkedList<>();
        try{
            return authorDao.searchAuthorsByCountry(country);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;
    }
    public List<Author>searchAuthorsByGender(Gender gender){
        List<Author> authors=new LinkedList<>();
        try{
            return authorDao.searchAuthorsByGender(gender);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return authors;
    }
}
