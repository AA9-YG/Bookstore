package com.books;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO{

    private Connection connection;

    public BookDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addBook(Book book) {
        try {

            PreparedStatement statement = connection.prepareStatement(
                    """
                     INSERT  INTO books
                     (title, author, genre, price)
                     VALUES(?,?,?,?);
                     """
            );

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());

            // Execute SQL statement
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Book getBook(int bookID) {
        Book book = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books WHERE bookID=?");
            statement.setInt(1, bookID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                double price = resultSet.getDouble("price");

                book = new Book(id, title, author, genre, price);
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                int id = resultSet.getInt("bookID");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                String genre = resultSet.getString("genre");
                double price = resultSet.getDouble("price");

                Book book = new Book(id, title, author, genre, price);
                bookList.add(book);

            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }

    @Override
    public void updateBook(Book book) {

        try {

            PreparedStatement statement = connection.prepareStatement(
                    """
                    UPDATE books
                    SET title = ?,
                        author = ?,
                        genre = ?,
                        price = ?
                    WHERE bookID = ?;
                    """
            );

            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setDouble(4, book.getPrice());
            statement.setInt(5, book.getBookID());

            // Execute SQL statement
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBook(int bookID) {
        try {

            PreparedStatement statement = connection.prepareStatement("DELETE FROM books WHERE bookID=?;");
            statement.setInt(1, bookID);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
