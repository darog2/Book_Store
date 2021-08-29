package com.dungeon.lesson.dao;

import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GenreDao {
    private final Connection connection;
    private static final String INSERT_GENRE =
            "insert into genres(name,description,year_of_origin) values(?,?,?);";
    private static final String SELECT_ALL="select id,name,description,year_of_origin from genres order by id;";
    private static final String DELETE_GENRE="delete from genres name=? and description=?;";
    private static final String SEARCH_BY_NAME="select id,name,description,year_of_original from genres WHERE lower(name) like lower(?);";
    private static final String SEARCH_BY_DESCRIPTION="select id,name,description,year_of_original from genres WHERE lower(description) like lower(?);";
    private static final String SEARCH_BY_YEAR_OF_ORIGINAL="select id,name,description,year_of_original from genres WHERE (original) (?);";

    public GenreDao(Connection connection) {
        this.connection = connection;
    }

    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> genres = new LinkedList<>();

        PreparedStatement statement = connection.prepareStatement(SELECT_ALL );
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Genre genre =
                    new Genre(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4)
                    );
            genres.add(genre);
        }
        resultSet.close();
        statement.close();

        return genres;
    }
    public void saveGenre(Genre genre) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_GENRE);
        statement.setString(1, genre.getName());
        statement.setString(2, genre.getDescription());
        statement.setInt(3, genre.getYearOfOrigin());
        statement.executeUpdate();
//        connection.commit();
        statement.close();
    }
    public void deleteGenre(Genre genre) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(DELETE_GENRE);
        statement.setString(1, genre.getName());
        statement.setString(2, genre.getDescription());
        statement.executeUpdate();
//        connection.commit();
        statement.close();

    }
    public List<Genre> searchByName(String name) throws SQLException {
        List<Genre> genres = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_NAME);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Genre genre=new Genre(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
            genres.add(genre);
        }
        resultSet.close();
        statement.close();
        return genres;
    }

    public List<Genre> searchByDescription(String description) throws SQLException {
        List<Genre> genres = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_DESCRIPTION);
        statement.setString(1, "%" + description + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Genre genre=new Genre(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
            genres.add(genre);
        }
        resultSet.close();
        statement.close();
        return genres;
    }

    public List<Genre> searchByYearOfOriginal(int yearOfOriginal) throws SQLException {
        List<Genre> genres = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_YEAR_OF_ORIGINAL);
        statement.setInt(1, yearOfOriginal);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Genre genre=new Genre(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getInt(4));
            genres.add(genre);
        }
        resultSet.close();
        statement.close();
        return genres;
    }
}
