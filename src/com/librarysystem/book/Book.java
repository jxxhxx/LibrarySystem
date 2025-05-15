package com.librarysystem.book;

import java.time.LocalDate;

public abstract class Book {
    private String title;
    private String author;
    private boolean isAvailable = true;
    private LocalDate dueDate;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
        dueDate = null;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String toString() {
        return String.format("[제목] %s | [저자] %s | [대여 가능] %s | [반납일] %s",
                title, author, isAvailable ? "O" : "X", dueDate != null ? dueDate : "-");
    }
}
