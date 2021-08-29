package com.dungeon.lesson.service;

import com.dungeon.lesson.dao.BookDao;
import com.dungeon.lesson.dao.GenreDao;
import com.dungeon.lesson.model.Book;
import com.dungeon.lesson.model.Genre;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GenreService {


    public static final String BORDER = "--------------------------------------------------------------------------"+System.lineSeparator();
    public static final String HEADER = "| id |      название      |       описание        |   год возникновеня   |"+System.lineSeparator();
    public static final String GENRE_FORMAT = "| %3d | %-18.18s | %-21.21s |     %4d           |%n";
    private final GenreDao genreDao;
    private final Scanner scanner = new Scanner(System.in);


    public GenreService(Connection connection){
        genreDao= new GenreDao(connection);
    }
    public void printGenres(List<Genre> genres) {
        if (genres.size() > 0) {
            StringBuilder builder = new StringBuilder();
            builder.append(BORDER);
            builder.append(HEADER);
            builder.append(BORDER);
            for (Genre genre : genres) {
                builder.append(GENRE_FORMAT.formatted(genre.getId(),
                        genre.getName(),
                        genre.getDescription(),
                        genre.getYearOfOrigin()));
            }
            builder.append(BORDER);
            System.out.println(builder.toString());

        } else {
            System.out.println("книги найдены");

        }
    }
    public List<Genre>getAllGenres(){
        List<Genre>genres= new LinkedList<>();
        try {
            return genreDao.getAllGenres();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
    public Genre createGenre() {
        Genre genre=new Genre();
        System.out.print("введите имя: ");
        genre.setName(scanner.nextLine());
        System.out.print("введите описание:  ");
        genre.setDescription(scanner.nextLine());
        System.out.print("введите год выпуска: ");
        genre.setYearOfOrigin(scanner.nextInt());
        saveGenre(genre);
        return genre;
    }

    private void saveGenre( Genre genre) {
        try {
            genreDao.saveGenre(genre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Genre> searchByName(String name){
        List<Genre>genres=new LinkedList<>();
        try {
            return genreDao.searchByName( name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
    public void deleteGenre(Genre genre) {
        try {
            genreDao.deleteGenre(genre);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteGenre() {
        List<Genre> genres = getAllGenres();
        printGenres(genres);
        System.out.println("выберите жанр для удаления: ");
        boolean isCorrect = false;
        do {
            int delete = scanner.nextInt();
            if (delete > 0 && delete <= genres.size()) {
               Genre genre = genres.get(delete - 1);
                deleteGenre(genre);
                isCorrect = true;
            } else {
                System.out.println("введите существующий номер: ");
            }
        } while (!isCorrect);
        System.out.println("жанр удален ");
    }


    public List<Genre> searchByDescription(String description){
        List<Genre>genres=new LinkedList<>();
        try {
            return genreDao.searchByDescription( description);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }

    public List<Genre> searchByYearOfOriginal(int yearOfOriginal){
        List<Genre>genres=new LinkedList<>();
        try {
            return genreDao.searchByYearOfOriginal(yearOfOriginal );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return genres;
    }
}
