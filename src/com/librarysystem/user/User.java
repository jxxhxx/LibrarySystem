package com.librarysystem.user;

import com.librarysystem.book.Book;

import java.util.List;

public interface User {
    void viewBooks(List<Book> books);
    void borrowBook(String title, List<Book> books);
    void returnBook(String title, List<Book> books);
    void checkOverdue();
    String getName();
}
