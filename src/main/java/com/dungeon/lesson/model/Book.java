package com.dungeon.lesson.model;

public class Book {

    private int id;
    private String name;
    private String author;
    private double price;
    private int yearOfIssue;

    public Book() {
    }

    public Book(int id, String name, String author,int yearOfIssue, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.yearOfIssue=yearOfIssue;
        this.price = price;

    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }
}
