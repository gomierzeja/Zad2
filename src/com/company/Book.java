package com.company;
public class Book {

    private int id;
    private String title;
    private String author;
    private int year;
    private int isbn;

    public Book() {

    }
    public Book(int id, String title, String author, int year, int isbn) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.year=year;
        this.isbn=isbn;
    }

    @Override
    public String toString() {
        return " Author: " + author + " Id: " + id + " Title: " + title + " Year: " + year + " Isbn: " + isbn;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
