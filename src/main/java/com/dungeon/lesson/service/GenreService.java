package com.dungeon.lesson.service;

import com.dungeon.lesson.dao.BookDao;
import com.dungeon.lesson.dao.GenreDao;

import java.sql.Connection;
import java.util.Scanner;

public class GenreService {


    private final GenreDao genreDao;
    private final Scanner scanner = new Scanner(System.in);


    public GenreService(Connection connection){
        genreDao= new GenreDao(connection);
    }
}
