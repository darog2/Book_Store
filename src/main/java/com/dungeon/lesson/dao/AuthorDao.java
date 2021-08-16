package com.dungeon.lesson.dao;

import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthorDao {
    private final Connection connection;
    private static final String INSERT_AUTHOR =
            "insert into authors(name,last_name,date_of_birth,country,gender) values(?,?,?,?,?::public.gender);";
    private static final String SEARCH_BY_NAME_AUTHOR = "select id,name ,last_name,date_of_birth,country,gender from authors WHERE  lower(name) like lower (?) ;";
    private static final String SELECT_ALL = "select id,name,last_name,date_of_birth,country,gender from authors order by id;";
    private static final String SEARCH_AUTHOR_BY_LAST_NAME = "select id,name ,last_name,date_of_birth ,country,gender from authors WHERE lower (last_name) like lower (?) ;";
    private static final String SEARCH_AUTHOR_BY_DATE_OF_BIRTH = "select id,name ,last_name,date_of_birth ,country,gender from authors WHERE extract(YEAR from date_of_birth)=? ;";
    private static final String SEARCH_AUTHOR_BY_COUNTRY = "select id,name ,last_name,date_of_birth ,country,gender from authors WHERE lower(country) like (?);";
    private static final String SEARCH_AUTHOR_BY_GENDER = "select id,name ,last_name,date_of_birth ,country,gender from authors WHERE gender=?::public.gender ;";

    public AuthorDao(Connection connection) {
        this.connection = connection;
    }


    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authors = new LinkedList<>();

        PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author =
                    new Author(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDate(4),
                            resultSet.getString(5),
                            Gender.valueOf(resultSet.getString(6))
                    );
            authors.add(author);
        }
        resultSet.close();
        statement.close();

        return authors;
    }

    public void saveAuthor(Author author) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_AUTHOR);
        statement.setString(1, author.getName());
        statement.setString(2, author.getLastName());
        statement.setDate(3, new Date(author.getDateOfBirth().getTime()));
        statement.setString(4, author.getCountry());
        statement.setString(5, author.getGender().toString());
        statement.executeUpdate();
//        connection.commit();
        statement.close();

    }

    public List<Author> searchAuthorsByName(String name) throws SQLException {
        List<Author> authors = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_NAME_AUTHOR);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    Gender.valueOf(resultSet.getString(6)));
            authors.add(author);
        }
        resultSet.close();
        statement.close();
        return authors;
    }

    public List<Author> searchAuthorsByLastName(String lastName) throws SQLException {
        List<Author> authors = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_AUTHOR_BY_LAST_NAME);
        statement.setString(1, "%" + lastName + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    Gender.valueOf(resultSet.getString(6)));
            authors.add(author);


        }
        resultSet.close();
        statement.close();
        return authors;
    }

    public List<Author> searchAuthorsByDateOfBirth(int dateOfBirth) throws SQLException {
        List<Author> authors = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_AUTHOR_BY_DATE_OF_BIRTH);
        statement.setInt(1, dateOfBirth);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    Gender.valueOf(resultSet.getString(6)));
            authors.add(author);


        }
        resultSet.close();
        statement.close();
        return authors;

    }

    public List<Author> searchAuthorsByCountry(String country) throws SQLException {
        List<Author> authors = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_AUTHOR_BY_COUNTRY);
        statement.setString(1, "%" + country + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    Gender.valueOf(resultSet.getString(6)));
            authors.add(author);


        }
        resultSet.close();
        statement.close();
        return authors;
    }
    public List<Author> searchAuthorsByGender(Gender gender) throws SQLException {
        List<Author> authors = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_AUTHOR_BY_GENDER);
        statement.setString(1,  gender.toString());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getDate(4),
                    resultSet.getString(5),
                    Gender.valueOf(resultSet.getString(6)));
            authors.add(author);


        }
        resultSet.close();
        statement.close();
        return authors;
    }
}
