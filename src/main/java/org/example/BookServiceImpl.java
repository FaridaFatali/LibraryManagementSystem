package org.example;

import java.util.*;

public class BookServiceImpl implements BookServiceInterface {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String CYAN = "\u001B[36m";
    Validator validator = new Validator();
    List<Book> books = new ArrayList<>();

    @Override
    public void addBook() {
        String bookId = validator.validateId();
        String author = validator.validateAuthor();
        String title = validator.validateTitle();
        String year = validator.validatePublishYear();
        Book book = new Book(bookId, author, title, year, "Available");
        books.add(book);
        System.out.println(GREEN + "Book Added Successfully! " + RESET);

    }

    @Override
    public void showAllBooks() {
        boolean flag = false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s%15s", "ID", "AUTHOR", "TITLE", "YEAR", "STATUS" + RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        for (Book book : books) {
            System.out.format("%s%15s%15s%15s%15s", book.getId(), book.getAuthor(), '"' + book.getTitle() + '"', book.getPublishYear(), book.getStatus());
            System.out.println();
            flag = true;
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if (!flag) {
            System.out.println(RED + "There are no books in library" + RESET);
        }
    }

    @Override
    public void showAllAvailableBooks() {
        boolean flag = false;
        System.out.println("\n----------------------------------------------------------------------------------------------");
        System.out.format(CYAN + "%s%15s%15s%15s%15s", "ID", "AUTHOR", "TITLE", "YEAR", "STATUS" + RESET);
        System.out.println("\n----------------------------------------------------------------------------------------------");

        if (books.size() > 0) {
            for (Book book : books) {
                if (book.getStatus() == "Available") {
                    System.out.format("%s%15s%15s%15s%15s",book.getId(), "  " +  book.getAuthor(), '"' + book.getTitle() + '"', book.getPublishYear(), book.getStatus());
                    System.out.println();
                    flag = true;
                }
            }
        } else {
            System.out.println(RED + "No books available in the library" + RESET);
        }
        System.out.println("\n----------------------------------------------------------------------------------------------");
        if (!flag) {
            System.out.println(RED + "There are no books with status Available" + RESET);
        }
    }

    @Override
    public void borrowBook() {
        String bookId = validator.validateId();
        boolean flag = false;
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.getStatus().equals("Available")) {
                flag = true;
                System.out.println(GREEN + "Book Borrowed Successfully!" + RESET);
                book.setStatus("Not Available");
                System.out.println("Borrowed Book Details: " + book);
            }
        }
        if (!flag) {
            System.out.println(RED + "This book is not available to borrow" + RESET);
        }

    }

    @Override
    public void returnBook() {
        boolean flag = false;
        String bookId = validator.validateId();
        for (Book book : books) {
            if (book.getId().equals(bookId) && book.getStatus().equals("Not Available")) {
                flag = true;
                System.out.println(GREEN + "Book Returned Successfully!" + RESET);
                book.setStatus("Available");
                System.out.println("Returned Book Details: " + book);
            }
        }
        if (!flag) {
            System.out.println(RED + "We can't return this book" + RESET);
        }
    }
}
