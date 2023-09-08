package org.example;

import java.util.Scanner;

/**
 * Practice: <a href="https://www.youtube.com/watch?v=9g4_3bFdhZc">...</a>
 * @author Farida Fatali 
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookServiceInterface service = new BookServiceImpl();

        do {
            System.out.println("Welcome to Book Management Application.");
            System.out.println("""
                    1. Add Book
                    2. Show All Books
                    3. Show Available Books
                    4. Borrow Book
                    5. Return Book
                    6. Exit
                    """);
            System.out.println("Enter Your Choice!");
            int choose = scanner.nextInt();

            switch (choose) {
                case 1 -> service.addBook();
                case 2 -> service.showAllBooks();
                case 3 -> service.showAllAvailableBooks();
                case 4 -> service.borrowBook();
                case 5 -> service.returnBook();
                case 6 -> {
                    System.out.println("Thank you for using our application!");
                    System.exit(0);
                }
                default -> System.out.println("Please Enter Valid Choice!");
            }
        }
        while (true);
    }
}