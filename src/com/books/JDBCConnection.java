package com.books;

import java.sql.*;

public class JDBCConnection {

    // Set up database connection properties
    private static final String URL = "jdbc:mysql://localhost:3306/book_db";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "1234";

    public static void getConnection() {

        Connection connection = null;

        // Load the JDBC driver
        // Checked exception (ClassNotFoundException) if argument not found
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            // Checked exception (SQLException) if no connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Execute SQL statements
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM books");
//
//            while (resultSet.next()) {
//                int id = resultSet.getInt("bookID");
//                String title = resultSet.getString("title");
//                String author = resultSet.getString("author");
//                String genre = resultSet.getString("genre");
//                double price = resultSet.getDouble("price");
//
//                System.out.println("ID: " + id + "\tTitle: " + title + "\tAuthor: " + author + "\tGenre: " + genre + "\tPrice: " + price);
//            }

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
