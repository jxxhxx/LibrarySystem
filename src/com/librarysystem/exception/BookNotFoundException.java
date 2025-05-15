package com.librarysystem.exception;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("도서를 찾을 수 없습니다.");
    }

    public BookNotFoundException(String title) {
        super("도서 \"" + title + "\" 을(를) 찾을 수 없습니다.");
    }
}
