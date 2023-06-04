package com.books;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    Book getBook(int id);

    List<Book> getAllBooks();

    void updateBook(Book book);

    void removeBook(int id);

}
