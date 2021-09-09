package com.dungeon.lesson.service;

import com.dungeon.lesson.model.Author;
import com.dungeon.lesson.model.Gender;
import com.dungeon.lesson.util.DateFormatUtil;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public abstract class AbstractService <T>{
    public abstract List<T>getAll();
    protected abstract void save(T item) ;

    public abstract T create() ;

    protected abstract void delete(T item) ;

    public abstract void delete() ;

    public abstract void print(List<T>items) ;
}
