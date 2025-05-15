package com.librarysystem.user;

import com.librarysystem.book.Book;
import com.librarysystem.book.PrintedBook;
import com.librarysystem.exception.BookNotFoundException;

import java.util.List;
import java.util.Scanner;

public class Admin implements User {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    @Override
    public void viewBooks(List<Book> books) {
        System.out.println("\n[전체 도서 목록]");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Override
    public void borrowBook(String title, List<Book> books) {
        System.out.println("[오류] 관리자는 도서를 대여할 수 없습니다.");
    }

    @Override
    public void returnBook(String title, List<Book> books) {
        System.out.println("[오류] 관리자는 도서를 반납할 수 없습니다.");
    }

    @Override
    public void checkOverdue() {
        System.out.println("[오류] 관리자는 연체 확인 기능을 사용할 수 없습니다.");
    }

    @Override
    public String getName() {
        return name;
    }

    public void manageBooks(List<Book> books) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n[도서 관리]");
            System.out.println("1. 도서 등록 | 2. 도서 삭제 | 0. 돌아가기");
            System.out.print("선택: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("도서 제목: ");
                    String title = scanner.nextLine();
                    System.out.print("저자: ");
                    String author = scanner.nextLine();
                    books.add(new PrintedBook(title, author));
                    System.out.println("[성공] 도서가 등록되었습니다.");
                    break;
                case 2:
                    System.out.print("삭제할 도서 제목: ");
                    String removeTitle = scanner.nextLine();
                    boolean removed = books.removeIf(book -> book.getTitle().equalsIgnoreCase(removeTitle));
                    if (removed) {
                        System.out.println("[성공] 도서가 삭제되었습니다.");
                    } else {
                        throw new BookNotFoundException(removeTitle);
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("[오류] 잘못된 입력입니다.");
            }
        }
    }
}
