package com.dungeon.lesson.dao;

import com.dungeon.lesson.model.Book;
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
            "insert into genres(id,name,description,year_of_origin) values(?,?,?,?);";







    public GenreDao(Connection connection) {
        this.connection = connection;
    }
    public List<Genre> getAllGenres() throws SQLException {
        List<Genre> genres = new LinkedList<>();

        PreparedStatement statement = connection.prepareStatement(INSERT_GENRE );
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
}
