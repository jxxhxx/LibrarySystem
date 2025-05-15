## Java mini-project 콘솔 기반 도서 대여 시스템

## 프로젝트 소개
도서 대여 및 반납할 수 있는 시스템을 구현한 프로젝트입니다.

## 개발 기간
2025.05.12(월) ~ 2025.05.14(수)

## 멤버
개인프로젝트입니다.

## 개발 환경
언어: Java 21
IDE: eclipse
운영 체제: Windows

## 주요 패키지 및 클래스 명
com.librarysystem.main
<br>-LibrarySystem.java

com.librarysystem.user
<br>-Admin.java
<br>-Professor.java
<br>-Student.java
<br>-User.java

com.librarysystem.book
<br>-Book.java
<br>-PrintedBook.java

com.librarysystem.file
<br>-FileManager.java

com.librarysystem.exception
<br>-BookNotFoundException.java
<br>-OverdueBookException.java
<br>-PermissionDeniedException.java

## UML 클래스 다이어그램

![클래스 다이어 그램](https://github.com/user-attachments/assets/35fc58ea-2263-4bce-9c08-df6b4138b3b8)


# com.librarysystem.main.LibrarySystem 메인 실행 클래스
![image](https://github.com/user-attachments/assets/2680c2c5-1a21-4e3d-85c7-54a097254ef2)

사용자의 이름과 역할(학생, 교수, 관리자)을 입력 받아 적절한 User 하위 클래스(Student, Professor, Admin) 객체를 생성.

![image](https://github.com/user-attachments/assets/ded1d9f3-a773-43e5-ac16-731b52f3a3e2)
![image](https://github.com/user-attachments/assets/6005ffd2-c238-4585-9269-52378e76ba61)

-프로그램 시작 시 파일(books.dat)에서 도서 목록을 불러오고, 없을 경우 기본 도서를 자동으로 등록.
<br>-프로그램 종료 시 FileManager.saveBooks()를 통해 도서 목록을 파일에 저장.

![image](https://github.com/user-attachments/assets/06d361d3-52a4-4c1f-8b23-5010866e330a)

모든 사용자가 다음 기능을 사용할 수 있음.
<br>1. 도서 목록 보기
<br>2. 도서 대여
<br>3. 도서 반납
<br>4. 연체 확인

![image](https://github.com/user-attachments/assets/e55a6b81-b6b7-4923-b241-ac14e05797f1)

-관리자는 도서 추가/삭제 등 관리자만이 이용할 수 있는 도서 관리 기능 사용.
<br>-일반 사용자(Student/Professor)는 접근 불가하며, 접근 시도 시 오류 메세지 출력.

# com.librarysystem.user.Admin
![image](https://github.com/user-attachments/assets/53346bb3-8054-409b-ad91-9f913decf2f4)

-관리자는 시스템에 등록된 모든 도서 목록을 조회 가능.
<br>-viewBooks() 메서드를 통해 리스트에 있는 모든 Book 객체를 출력.

![image](https://github.com/user-attachments/assets/8aac2bdc-ce78-423c-a7fe-d3dbf0321472)

-manageBooks() 내의 메뉴에서 도서 제목과 저자명을 입력받아 새 도서를 생성하고 등록.
<br>-PrintedBook 객체로 추가되며, 등록 성공 메시지를 출력

![image](https://github.com/user-attachments/assets/33b32fc4-f0af-4ce1-af71-ed2391c5f9e3)

-도서 제목을 입력받아 해당 도서를 제목 기준으로 검색 후 삭제.
<br>-일치하는 도서가 없으면 BookNotFoundException 예외 발생.

![image](https://github.com/user-attachments/assets/ec16d530-373d-4aa2-8641-4f10e8c5cd31)

-관리자는 도서 대여, 반납, 연체 확인 기능 사용 불가.
<br>-해당 메서드 호출 시 명확한 제한 메시지 출력.

![image](https://github.com/user-attachments/assets/e6b0d191-1b0d-4b01-9d18-168cbd210642)

-반복적으로 도서 등록/삭제 기능을 실행할 수 있게 메뉴 형태로 구성.
0. 돌아가기 선택 시 도서 관리 메뉴에서 빠져나옴.

# com.librarysystem.user.Professor
![image](https://github.com/user-attachments/assets/72993dbb-01d7-44eb-b9de-c327941b1c1a)

-시스템에 등록된 모든 도서의 제목, 상태, 반납 기한 등 정보를 출력.
<br>-교수는 관리자와 달리 도서 목록만 조회 가능.

![image](https://github.com/user-attachments/assets/5bf3bb98-a8cd-4820-bb64-d8e96c2c7f07)

-사용자가 입력한 제목을 가진 도서를 검색하여 대여 가능 여부를 확인 후 대여 처리.
<br>-반납 기한은 14일로 설정되며, 대여 중인 도서 목록에 추가.

![image](https://github.com/user-attachments/assets/6933ea25-9380-4e6a-a007-ee4e90567ecb)

-교수의 borrowedBooks 목록에서 제목이 일치하는 도서를 찾아 반납 처리.
<br>-반납 완료 후 해당 도서는 borrowedBooks 목록에서 제거.

![image](https://github.com/user-attachments/assets/80a847aa-d495-4a20-a36a-3336e98db778)

-borrowedBooks 중에서 반납 기한이 현재 날짜 이전인 도서를 확인하고, 연체된 도서 제목을 출력

# com.librarysystem.user.Student
![image](https://github.com/user-attachments/assets/72993dbb-01d7-44eb-b9de-c327941b1c1a)

-시스템에 등록된 모든 도서의 제목, 상태, 반납 기한 등 정보를 출력.
<br>-학생은 관리자와 달리 도서 목록만 조회 가능.

![image](https://github.com/user-attachments/assets/5bf3bb98-a8cd-4820-bb64-d8e96c2c7f07)

-사용자가 입력한 제목을 가진 도서를 검색하여 대여 가능 여부를 확인 후 대여 처리.
<br>-반납 기한은 7일로 설정되며, 대여 중인 도서 목록에 추가.

![image](https://github.com/user-attachments/assets/6933ea25-9380-4e6a-a007-ee4e90567ecb)

-학생의 borrowedBooks 목록에서 제목이 일치하는 도서를 찾아 반납 처리.
<br>-반납 완료 후 해당 도서는 borrowedBooks 목록에서 제거.

![image](https://github.com/user-attachments/assets/80a847aa-d495-4a20-a36a-3336e98db778)

-borrowedBooks 중에서 반납 기한이 현재 날짜 이전인 도서를 확인하고, 연체된 도서 제목을 출력

## com.librarysystem.book.Book
![image](https://github.com/user-attachments/assets/686cc17e-109b-4a7b-9b62-68652669dd0b)

-도서의 isAvailable 상태를 false로 바꾸어 대여 중 상태로 변경.

![image](https://github.com/user-attachments/assets/c2815d89-3a83-4530-af96-f852cf028002)

-도서의 isAvailable 상태를 true로 되돌리고, 반납 기한을 초기화(null)

![image](https://github.com/user-attachments/assets/2b5545d7-ae15-4b64-a46e-5a58287f69f9)

-setDueDate(LocalDate)로 반납 날짜 설정.
<br>-getDueDate()로 현재 반납 기한 조회

![image](https://github.com/user-attachments/assets/67bc4790-cbb2-4e92-a4ab-8b0907736905)

-제목, 저자, 대여 가능 여부, 반납 기한을 포맷에 맞춰 문자열로 출력.

## com.librarysystem.book.PrintedBook
![image](https://github.com/user-attachments/assets/bcaaa721-ab15-45ae-ab59-71106155324a)

-PrintedBook 생성 시, 부모 클래스 Book의 생성자를 호출해 제목과 저자를 초기화

## com.librarysystem.file.FileManager
![image](https://github.com/user-attachments/assets/053c730b-c87f-49a6-938a-2821a0e2e7c9)

-List<Book> 데이터를 books.txt 파일에 저장.
<br>-각 도서의 제목, 저자, 대여 가능 여부를 CSV 형식으로 저장.

![image](https://github.com/user-attachments/assets/4435c014-bda1-447a-bef0-d6a901ce6e08)

-books.txt 파일로부터 도서 목록을 읽어 List<Book> 형태로 반환.
<br>-저장된 문자열을 파싱하여 PrintedBook 객체로 생성하며, 대여 중인 책은 book.borrow()로 상태 반영.

![image](https://github.com/user-attachments/assets/aa244d68-bc50-4810-95bd-19e152f4639d)

-파일이 없을 경우에는 새로 만들지 않고 빈 리스트 반환.
<br>-IOException 발생 시 사용자에게 오류 메시지 출력.

## com.librarysystem.exception
![image](https://github.com/user-attachments/assets/9e447912-cf2d-4121-b797-de754f910b03)

<br>-BookNotFoundException.java 도서 검색이나 반납, 삭제 시 해당 도서를 찾지 못할 경우 발생하는 사용자 정의 예외 클래스

![image](https://github.com/user-attachments/assets/2a3811b0-32c2-4de4-854c-bec29beb0084)
<br>-OverdueBookException.java 도서의 반납 기한이 지났을 때 발생하는 사용자 정의 예외 클래스

![image](https://github.com/user-attachments/assets/cd1df991-b452-4770-9687-55787d038ff2)
<br>-PermissionDeniedException.java 도서 대여/반납 등 사용자 행위에 대한 접근 권한이 없을 경우 발생하는 사용자 정의 예외


