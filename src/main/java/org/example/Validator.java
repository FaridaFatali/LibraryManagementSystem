package org.example;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    private static Pattern ID_PATTERN = Pattern.compile("^\\d{1,4}$");
    private static Pattern Author_Pattern = Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern Title_Pattern = Pattern.compile("^[a-zA-Z ]+$");
    private static Pattern PublishYear_Pattern = Pattern.compile("^\\d{4}$");

    Scanner scanner = new Scanner(System.in);

    public String validateId() {
        String bookId;
        while (true) {
            System.out.println("Enter Book ID");
            bookId = scanner.nextLine();
            if (!ID_PATTERN.matcher(bookId).matches()) {
                System.out.println(RED + "ENTER VALID BOOK ID!" + RESET);
            } else {
                break;
            }
        }
        return bookId;
    }

    public String validateAuthor() {
        String bookAuthor;
        while (true) {
            System.out.println("Enter Author");
            bookAuthor = scanner.nextLine();
            if (!Author_Pattern.matcher(bookAuthor).matches()) {
                System.out.println(RED + "Please Enter Valid Author" + RESET);
            } else {
                break;
            }
        }
        return bookAuthor;
    }

    public String validateTitle() {
        String bookTitle;
        while (true) {
            System.out.println("Enter Title");
            bookTitle = scanner.nextLine();
            if (!Title_Pattern.matcher(bookTitle).matches()) {
                System.out.println(RED + "Please Enter Valid Title" + RESET);
            } else {
                break;
            }
        }
        return bookTitle;
    }

    public String validatePublishYear() {
        String year;
        while (true) {
            System.out.println("Enter Publish Year of Book:");
            year = scanner.nextLine();
            if (!PublishYear_Pattern.matcher(year).matches()) {
                System.out.println(RED + "Enter Valid Publish Year" + RESET);
            } else {
                break;
            }
        }
        return year;
    }
}
