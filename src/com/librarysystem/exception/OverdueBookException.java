package com.librarysystem.exception;

public class OverdueBookException extends RuntimeException {
    public OverdueBookException(String title) {
        super("도서 \"" + title + "\" 의 반납 기한이 지났습니다.");
    }
}
