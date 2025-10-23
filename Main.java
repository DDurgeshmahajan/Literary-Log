/*
 * Author: Durgesh Mahajan
 * Date: 2023-10-05
 * Project: Literary Log
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        LiteraryLogManager manager = new LiteraryLogManager();

        Scanner scanner = new Scanner(System.in);
        String defaultFilename = "books.txt";

        try {
            manager.loadBooksFromFile(defaultFilename);
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found. Starting with an empty log.");
        }

        while (true) {
            displayMenu();
            String choice = scanner.nextLine().trim().toUpperCase();

            switch (choice) {
                case "1":
                    addBook(scanner, manager);
                    break;
                case "2":
                    manager.viewAllBooks();
                    break;
                case "3":
                    viewBooksByStatus(scanner, manager);
                    break;
                case "4":
                    updateBook(scanner, manager);
                    break;
                case "5":
                    deleteBook(scanner, manager);
                    break;
                case "6":
                    searchBooks(scanner, manager);
                    break;
                case "7":
                    manager.saveBooksToFile(defaultFilename);
                    System.out.println("Books saved. Exiting...\n");
                    System.exit(0);
                case "8":
                    System.out.println("Exiting...\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Literary Log Menu:");
        System.out.println("1. Add New Book");
        System.out.println("2. View All Books");
        System.out.println("3. View Books by Status");
        System.out.println("4. Update Book Details");
        System.out.println("5. Delete Book");
        System.out.println("6. Search Books");
        System.out.println("7. Save and Exit");
        System.out.println("8. Exit (without saving)");
        System.out.print("Enter your choice: ");
    }

    private static void addBook(Scanner scanner, LiteraryLogManager manager) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine().trim();
        System.out.print("Enter book genre: ");
        String genre = scanner.nextLine().trim();
        System.out.print("Enter book status (TO_READ, READING, FINISHED): ");
        String status = scanner.nextLine().trim().toUpperCase();
        String notes = "";
        int rating = 0;

        if (status.equals("FINISHED")) {
            System.out.print("Enter book notes (optional): ");
            notes = scanner.nextLine().trim();
            System.out.print("Enter book rating (1-5): ");
            rating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (rating < 1 || rating > 5) {
                System.out.println("Invalid rating. Rating must be between 1 and 5. Using default (0).\n");
                rating = 0;
            }
        }

        Book book = new Book(title, author, genre, status, notes, rating);
        manager.addBook(book);
        System.out.println("Book added successfully.\n");
    }

    private static void viewBooksByStatus(Scanner scanner, LiteraryLogManager manager) {
        System.out.print("Enter status to view (TO_READ, READING, FINISHED): ");
        String status = scanner.nextLine().trim().toUpperCase();
        manager.viewBooksByStatus(status);
    }

    private static void updateBook(Scanner scanner, LiteraryLogManager manager) {
        System.out.print("Enter book title to update: ");
        String title = scanner.nextLine().trim();
        System.out.print("Enter new book status (TO_READ, READING, FINISHED): ");
        String newStatus = scanner.nextLine().trim().toUpperCase();
        String newNotes = "";
        int newRating = 0;

        if (newStatus.equals("FINISHED")) {
            System.out.print("Enter new book notes (optional): ");
            newNotes = scanner.nextLine().trim();
            System.out.print("Enter new book rating (1-5): ");
            newRating = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (newRating < 1 || newRating > 5) {
                System.out.println("Invalid rating. Rating must be between 1 and 5. Using default (0).\n");
                newRating = 0;
            }
        }

        if (manager.updateBook(title, newStatus, newNotes, newRating)) {
            System.out.println("Book updated successfully.\n");
        } else {
            System.out.println("Book not found.\n");
        }
    }

    private static void deleteBook(Scanner scanner, LiteraryLogManager manager) {
        System.out.print("Enter book title to delete: ");
        String title = scanner.nextLine().trim();

        if (manager.deleteBook(title)) {
            System.out.println("Book deleted successfully.\n");
        } else {
            System.out.println("Book not found.\n");
        }
    }

    private static void searchBooks(Scanner scanner, LiteraryLogManager manager) {
        System.out.print("Enter query to search (title or author): ");
        String query = scanner.nextLine().trim().toLowerCase();
        manager.searchBook(query).forEach(System.out::println);
    }
}
