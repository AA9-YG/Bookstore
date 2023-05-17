package com.books;

public class Book {

    private static int id = 1;

    private int bookID;

    private String title;

    private String author;

    private String genre;

    private double price;

    public Book() {
        bookID = id++;
        title = "Book #" + bookID;
        author = "Author #" + bookID;
        genre = "N/A";
        price = 9.99;
    }

    public Book(String title, String author, String genre, double price) {
        bookID = id++;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public static int getId() {
        return id;
    }

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public double getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                '}';
    }

}