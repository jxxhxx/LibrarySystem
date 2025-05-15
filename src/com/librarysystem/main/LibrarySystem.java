package com.librarysystem.main;

import com.librarysystem.book.Book;
import com.librarysystem.book.PrintedBook;
import com.librarysystem.user.*;
import com.librarysystem.file.FileManager;  // 추가된 import
import java.util.List;
import java.util.Scanner;

public class LibrarySystem {
    private static final List<Book> books = FileManager.loadBooks(); // 파일에서 도서 목록을 불러옴

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = null;

        // 만약 파일에 도서 목록이 없다면 기본 도서 등록
        if (books.isEmpty()) {
            books.add(new PrintedBook("자바의 정석", "남궁성"));
            books.add(new PrintedBook("Effective Java", "Joshua Bloch"));
            books.add(new PrintedBook("Clean Code", "Robert C. Martin"));
        }

        System.out.println("=== 도서 대여 시스템 ===");
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();

        System.out.print("역할을 선택하세요 (1. 학생 / 2. 교수 / 3. 관리자): ");
        int role = scanner.nextInt();
        scanner.nextLine();

        switch (role) {
            case 1: user = new Student(name); break;
            case 2: user = new Professor(name); break;
            case 3: user = new Admin(name); break;
            default:
                System.out.println("[오류] 잘못된 입력입니다.");
                System.exit(0);
        }

        while (true) {
            System.out.println("\n[메뉴]");
            System.out.println("1. 도서 목록 보기 | 2. 도서 대여 | 3. 도서 반납 | 4. 연체 확인");
            if (user instanceof Admin) {
                System.out.println("5. 도서 관리 | 0. 종료");
            } else {
                System.out.println("0. 종료");
            }
            System.out.print("선택: ");
            int menu = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (menu) {
                    case 1: user.viewBooks(books); break;
                    case 2:
                        System.out.print("대여할 도서 제목 입력: ");
                        user.borrowBook(scanner.nextLine(), books);
                        break;
                    case 3:
                        System.out.print("반납할 도서 제목 입력: ");
                        user.returnBook(scanner.nextLine(), books);
                        break;
                    case 4: user.checkOverdue(); break;
                    case 5:
                        if (user instanceof Admin) {
                            ((Admin) user).manageBooks(books);
                        } else {
                            System.out.println("[오류] 권한이 없습니다.");
                        }
                        break;
                    case 0:
                        // 도서 목록을 파일에 저장하고 종료
                        FileManager.saveBooks(books); 
                        System.out.println("시스템을 종료합니다.");
                        System.exit(0);
                    default:
                        System.out.println("[오류] 잘못된 입력입니다.");
                }
            } catch (Exception e) {
                System.out.println("[예외 발생] " + e.getMessage());
            }
        }
    }
}
