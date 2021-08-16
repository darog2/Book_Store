package com.dungeon.lesson.model;



public class Genre {
    private int id;
    private String name;
    private String description;
    private int yearOfOrigin;

    public Genre() {
    }

    public Genre(int id, String name, String description, int yearOfOrigin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.yearOfOrigin = yearOfOrigin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYearOfOrigin() {
        return yearOfOrigin;
    }

    public void setYearOfOrigin(int yearOfOrigin) {
        this.yearOfOrigin = yearOfOrigin;
    }
}

