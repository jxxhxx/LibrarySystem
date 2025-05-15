package com.librarysystem.file;

import com.librarysystem.book.Book;
import com.librarysystem.book.PrintedBook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private static final String FILE_NAME = "books.txt";

    // 도서 목록 저장
    public static void saveBooks(List<Book> books) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                writer.write(book.getTitle() + "," + book.getAuthor() + "," + book.isAvailable());
                writer.newLine();
            }
            System.out.println("[파일 저장] 도서 목록이 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("[오류] 파일 저장 중 문제가 발생했습니다: " + e.getMessage());
        }
    }

    // 도서 목록 불러오기
    public static List<Book> loadBooks() {
        List<Book> books = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            System.out.println("[정보] 저장된 도서 목록이 없습니다.");
            return books;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String title = parts[0];
                    String author = parts[1];
                    boolean available = Boolean.parseBoolean(parts[2]);

                    PrintedBook book = new PrintedBook(title, author);
                    if (!available) {
                        book.borrow();
                    }
                    books.add(book);
                }
            }
            System.out.println("[파일 불러오기] 도서 목록이 로드되었습니다.");
        } catch (IOException e) {
            System.out.println("[오류] 파일 로딩 중 문제가 발생했습니다: " + e.getMessage());
        }

        return books;
    }
}
