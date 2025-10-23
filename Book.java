public class Book {
    private String title;
    private String author;
    private String genre;
    private String status;
    private String notes;
    private int rating;

    public Book(String title, String author, String genre, String status, String notes, int rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
        this.notes = notes;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Status: " + status + ", Notes: " + notes + ", Rating: " + rating;
    }
}
