```markdown
# Literary Log

## Project Description
Welcome to **Literary Log**! This project is a simple command-line application designed to help you manage your personal book collection. Whether you're an avid reader or just starting out, Literary Log allows you to add, view, update, delete, and search for books, as well as keep track of your reading progress.

## Features
- **Add New Book:** Easily add new books to your collection with details like title, author, genre, and status.
- **View All Books:** See a list of all the books in your collection.
- **View Books by Status:** Filter books by their reading status (TO_READ, READING, FINISHED).
- **Update Book Details:** Modify the status, notes, and rating of a book.
- **Delete Book:** Remove a book from your collection.
- **Search Books:** Find books by title or author.
- **Save and Load:** Save your book collection to a file and load it when you start the application.

## Usage Instructions
### Prerequisites
- Java 8 or higher installed on your system.

### Running the Application
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/DDurgeshmahajan/LiteraryLog.git
   ```

2. **Compile the Java Files:**
   Navigate to the project directory and compile the Java files using the following command:
   ```sh
   javac Main.java LiteraryLogManager.java Book.java
   ```

3. **Run the Application:**
   Run the `Main` class to start the application:
   ```sh
   java Main
   ```

### Menu Options
- **1. Add New Book:** Enter the book's title, author, genre, and status. If the status is "FINISHED," you can also add notes and a rating.
- **2. View All Books:** Display all the books in your collection.
- **3. View Books by Status:** Filter books by their reading status.
- **4. Update Book Details:** Update the status, notes, and rating of a book.
- **5. Delete Book:** Remove a book from your collection.
- **6. Search Books:** Search for books by title or author.
- **7. Save and Exit:** Save your book collection to a file and exit the application.
- **8. Exit (without saving):** Exit the application without saving changes.

## Example Usage
### Adding a Book
```sh
1. Add New Book
Enter book title: The Great Gatsby
Enter book author: F. Scott Fitzgerald
Enter book genre: Classic
Enter book status (TO_READ, READING, FINISHED): TO_READ
```

### Viewing All Books
```sh
2. View All Books
Title: The Great Gatsby, Author: F. Scott Fitzgerald, Genre: Classic, Status: TO_READ, Notes: , Rating: 0
```

### Updating a Book
```sh
4. Update Book Details
Enter book title to update: The Great Gatsby
Enter new book status (TO_READ, READING, FINISHED): FINISHED
Enter new book notes (optional): Great read!
Enter new book rating (1-5): 5
Book updated successfully.
```

### Searching for Books
```sh
6. Search Books
Enter query to search (title or author): Fitzgerald
Title: The Great Gatsby, Author: F. Scott Fitzgerald, Genre: Classic, Status: FINISHED, Notes: Great read!, Rating: 5
```

## Contact
If you have any questions or suggestions, feel free to reach out to me at ashamahajan955@gmail.com.

Enjoy using **Literary Log**! Happy reading!
```

This `README.md` file provides a clear and concise overview of the **Literary Log** project, including its features, usage instructions, and an example of how to use the application. It is designed to be beginner-friendly and easy to understand.