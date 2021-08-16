package com.dungeon.lesson.dao;

import com.dungeon.lesson.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class BookDao {
    private final Connection connection;
    private static final String INSERT_BOOK =
            "insert into books(name,author,year_of_issue,price) values(?,?,?,?);";
    private static final String DELETE_BOOK = "delete from books where name=? and author=?;";
    private static final String SELECT = "select id,name ,author,year_of_issue, price from books order by id;";
    private static final String SEARCH_BY_NAME = "select id,name ,author,year_of_issue ,price from books WHERE lower (name) like lower (?) ;";
    private static final String SEARCH_BY_AUTHOR = "select id,name ,author,year_of_issue ,price from bпooks WHERE lower (author) like lower (?) ;";
    private static final String SEARCH_BY_YEAR_ISSUE = "select id,name ,author,year_of_issue ,price from books WHERE year_of_issue = ? ;";

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    public void saveBook(Book book) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(INSERT_BOOK);
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.setInt(3, book.getYearOfIssue());
        statement.setDouble(4, book.getPrice());
        statement.executeUpdate();
//        connection.commit();
        statement.close();

    }

    public void deleteBook(Book book) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(DELETE_BOOK);
        statement.setString(1, book.getName());
        statement.setString(2, book.getAuthor());
        statement.executeUpdate();
//        connection.commit();
        statement.close();

    }

    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new LinkedList<>();

        PreparedStatement statement = connection.prepareStatement(SELECT);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book =
                    new Book(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5)
                    );
            books.add(book);
        }
        resultSet.close();
        statement.close();

        return books;
    }

    public List<Book> searchBooks(String name) throws SQLException {
        List<Book> books = new LinkedList<>();

        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_NAME);
        statement.setString(1, "%" + name + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book =
                    new Book(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5)
                    );
            books.add(book);
        }
        resultSet.close();
        statement.close();

        return books;

    }

    public List<Book> searchBooksByAuthor(String author) throws SQLException {
        List<Book> books = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_AUTHOR);
        statement.setString(1, "%" + author + "%");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book =
                    new Book(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5)
                    );
            books.add(book);
        }
        resultSet.close();
        statement.close();

        return books;

    }
    public List<Book> searchBooksByYear(int yearOfIssue ) throws SQLException {
        List<Book> books = new LinkedList<>();
        PreparedStatement statement = connection.prepareStatement(SEARCH_BY_YEAR_ISSUE);
        statement.setInt(1, yearOfIssue);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Book book =
                    new Book(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getDouble(5)
                    );
            books.add(book);
        }
        resultSet.close();
        statement.close();

        return books;
    }
}
