package org.howard.edu.lsp.midterm.question2;

/**
 * The Book class represents a book in a library.
 * It includes attributes like title, author, ISBN, and yearPublished.
 */
public class Book {
    private String title;
    private String author;
    private String ISBN;
    private int yearPublished;

    // Constructor
    public Book(String title, String author, String ISBN, int yearPublished) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.yearPublished = yearPublished;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // Override equals() method to compare books by ISBN and author
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Check if both references are the same
        if (obj == null || getClass() != obj.getClass()) return false; // Check if obj is null or not a Book

        Book book = (Book) obj;
        return this.ISBN.equals(book.ISBN) && this.author.equals(book.author);
    }

    // Override toString() to display book details
    @Override
    public String toString() {
        return "Title: " + title + 
               ", Author: " + author + 
               ", ISBN: " + ISBN + 
               ", Year Published: " + yearPublished;
    }
}
