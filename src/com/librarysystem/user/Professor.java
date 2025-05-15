package com.librarysystem.user;

import com.librarysystem.book.Book;
import com.librarysystem.exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor implements User {
    private String name;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Professor(String name) {
        this.name = name;
    }

    @Override
    public void viewBooks(List<Book> books) {
        System.out.println("\n[도서 목록]");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public void borrowBook(String title, List<Book> books) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                if (!book.isAvailable()) {
                    throw new PermissionDeniedException("이미 대여 중인 도서입니다.");
                }
                book.borrow();
                book.setDueDate(LocalDate.now().plusDays(14));
                borrowedBooks.add(book);
                System.out.println("[성공] 도서를 대여했습니다.");
                return;
            }
        }
        throw new BookNotFoundException(title);
    }

    @Override
    public void returnBook(String title, List<Book> books) {
        for (Book book : borrowedBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                borrowedBooks.remove(book);
                System.out.println("[성공] 도서를 반납했습니다.");
                return;
            }
        }
        throw new BookNotFoundException(title);
    }

    @Override
    public void checkOverdue() {
        System.out.println("\n[연체 도서 확인]");
        for (Book book : borrowedBooks) {
            if (book.getDueDate().isBefore(LocalDate.now())) {
                System.out.println("연체 도서: " + book.getTitle());
            }
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
