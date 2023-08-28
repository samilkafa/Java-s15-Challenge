package com.workintech.library.model;

import com.workintech.library.helper.Genre;

import java.util.*;

public class Library {

    private List<Book> books;
    private Set<Reader> readers;
    private Map<Book, Reader> borrowedBooks;

    public Library(List<Book> books, Set<Reader> readers) {
        this.books = books;
        this.readers = readers;
        this.borrowedBooks = new HashMap<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Set<Reader> getReaders() {
        return readers;
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public Map<Book, Reader> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(Map<Book, Reader> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void newBook(Book book) {
        books.add(book);
    }

    public void updateBook(Book bookToUpdate, String newTitle, double newPrice) {
        for (Book book : books) {
            if (book.equals(bookToUpdate)) {
                book.setTitle(newTitle);
                book.setPrice(newPrice);
                System.out.println("Book details updated successfully.");
                return;
            }
        }
        System.out.println("Book not found for updating.");
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> listBooksByCategory(Genre category) {
        List<Book> booksInCategory = new ArrayList<>();
        for (Book book : books) {
            if (book.getGenre() == category) {
                booksInCategory.add(book);
            }
        }
        return booksInCategory;
    }

    public List<Book> listBooksByAuthor(Author author) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public void lendBook(Reader reader, Book book) {
        if (borrowedBooks.containsKey(book)) {
            System.out.println("The book is already borrowed by " + borrowedBooks.get(book).getName());
        } else {
            borrowedBooks.put(book, reader);
            reader.borrowBook(book);
            book.setStatus("Borrowed");
            System.out.println(book.getTitle() + " has been lent to " + reader.getName());
        }
    }

    public void takeBackBook(Book book) {
        if (borrowedBooks.containsKey(book)) {
            Reader reader = borrowedBooks.get(book);
            borrowedBooks.remove(book);
            reader.returnBook(book);
            book.setStatus("Available");
            System.out.println(book.getTitle() + " has been taken back from " + reader.getName());
        } else {
            System.out.println("The book is not currently borrowed.");
        }
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println("- " + book.getTitle());
        }
    }
}
