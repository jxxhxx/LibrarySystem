# LibrarySystem
## java mini-project

## 콘솔 기반 도서 대여 시스템

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
com.librarysystem.book
<br>-Book.java
<br>-PrintedBook.java

<br>-com.librarysystem.exception
<br>-BookNotFoundException.java
<br>-OverdueBookException.java
<br>-PermissionDeniedException.java

com.librarysystem.file
<br>-FileManager.java

com.librarysystem.main
<br>-LibrarySystem.java

com.librarysystem.user
<br>-Admin.java
<br>-Professor.java
<br>-Student.java
<br>-User.java

# com.librarysystem.main 메인 실행 클래스
![image](https://github.com/user-attachments/assets/2680c2c5-1a21-4e3d-85c7-54a097254ef2)

사용자의 이름과 역할(학생, 교수, 관리자)을 입력 받아 적절한 User 하위 클래스(Student, Professor, Admin) 객체를 생성.

![image](https://github.com/user-attachments/assets/ded1d9f3-a773-43e5-ac16-731b52f3a3e2)
![image](https://github.com/user-attachments/assets/6005ffd2-c238-4585-9269-52378e76ba61)

프로그램 시작 시 파일(books.dat)에서 도서 목록을 불러오고, 없을 경우 기본 도서를 자동으로 등록.
<br>-프로그램 종료 시 FileManager.saveBooks()를 통해 도서 목록을 파일에 저장.

![image](https://github.com/user-attachments/assets/06d361d3-52a4-4c1f-8b23-5010866e330a)

모든 사용자가 다음 기능을 사용할 수 있음.
<br>1. 도서 목록 보기
<br>2. 도서 대여
<br>3. 도서 반납
<br>4. 연체 확인

![image](https://github.com/user-attachments/assets/e55a6b81-b6b7-4923-b241-ac14e05797f1)

관리자는 도서 추가/삭제 등 관리자만이 이용할 수 있는 도서 관리 기능 사용.
<br>-일반 사용자(Student/Professor)는 접근 불가하며, 접근 시도 시 오류 메세지 출력.






