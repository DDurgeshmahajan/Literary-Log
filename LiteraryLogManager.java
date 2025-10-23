import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class LiteraryLogManager {
    private List<Book> books;

    public LiteraryLogManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void viewAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the log.\n");
        } else {
            books.forEach(System.out::println);
        }
    }

    public void viewBooksByStatus(String status) {
        List<Book> filteredBooks = books.stream()
            .filter(book -> book.getStatus().equals(status))
            .collect(Collectors.toList());

        if (filteredBooks.isEmpty()) {
            System.out.println("No books with status: " + status + "\n");
        } else {
            filteredBooks.forEach(System.out::println);
        }
    }

    public boolean updateBook(String title, String newStatus, String newNotes, int newRating) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setStatus(newStatus);
                book.setNotes(newNotes);
                if (newStatus.equals("FINISHED")) {
                    book.setRating(newRating);
                }
                return true;
            }
        }
        return false;
    }

    public boolean deleteBook(String title) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                books.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Book> searchBook(String query) {
        return books.stream()
            .filter(book -> book.getTitle().toLowerCase().contains(query) || book.getAuthor().toLowerCase().contains(query))
            .collect(Collectors.toList());
    }

    public void saveBooksToFile(String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Book book : books) {
                writer.write(book.getTitle() + "|" + book.getAuthor() + "|" + book.getGenre() + "|" + book.getStatus() + "|" + book.getNotes() + "|" + book.getRating() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving books to file: " + e.getMessage());
        }
    }

    public void loadBooksFromFile(String filename) throws FileNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\|");
                if (parts.length == 6) {
                    Book book = new Book(
                        parts[0],
                        parts[1],
                        parts[2],
                        parts[3],
                        parts[4],
                        Integer.parseInt(parts[5])
                    );
                    books.add(book);
                }
            }
        }
    }
}
