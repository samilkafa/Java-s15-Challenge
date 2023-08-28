package com.workintech.library.main;

import com.workintech.library.helper.Genre;
import com.workintech.library.helper.Role;
import com.workintech.library.model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Library library = new Library(new ArrayList<>(), new HashSet<>());
        Librarian librarian = new Librarian(1, "John Malkovich", Role.ADMIN, "3141");

        Book book1 = new Book(1, "F. Scott Fitzgerald", "The Great Gatsby", 19.99, "Available", 4, "23.09.2007", Genre.TRAGEDY_AND_DRAMA);
        Book book2 = new Book(2, "Harper Lee", "To Kill a Mockingbird", 15.99, "Available", 5, "15.05.2005", Genre.TRAGEDY_AND_DRAMA);
        Book book3 = new Book(3, "George Orwell", "1984", 12.99, "Available", 3, "12.12.2010", Genre.SCI_FI);
        Book book4 = new Book(4, "J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 24.99, "Available", 6, "02.04.2001", Genre.FANTASY);
        Book book5 = new Book(5, "Agatha Christie", "Murder on the Orient Express", 10.99, "Available", 2, "18.08.1998", Genre.CRIME_AND_MYSTERY);
        Book book6 = new Book(6, "Jane Austen", "Pride and Prejudice", 14.99, "Available", 5, "30.03.2015", Genre.ROMANCE);
        Book book7 = new Book(7, "J.R.R. Tolkien", "The Hobbit", 18.99, "Available", 4, "07.11.2003", Genre.FANTASY);
        Book book8 = new Book(8, "Leo Tolstoy", "War and Peace", 29.99, "Available", 7, "10.07.2012", Genre.HISTORICAL_FICTION);
        Book book9 = new Book(9, "Stephen King", "The Shining", 16.99, "Available", 3, "05.09.2019", Genre.HORROR);
        Book book10 = new Book(10, "Mark Twain", "The Adventures of Huckleberry Finn", 11.99, "Available", 5, "22.06.2008", Genre.ADVENTURE);

        library.newBook(book1);
        library.newBook(book2);
        library.newBook(book3);
        library.newBook(book4);
        library.newBook(book5);
        library.newBook(book6);
        library.newBook(book7);
        library.newBook(book8);
        library.newBook(book9);
        library.newBook(book10);

        Author author1 = new Author(1, "F. Scott Fitzgerald", Role.AUTHOR);
        Author author2 = new Author(2, "Harper Lee", Role.AUTHOR);
        Author author3 = new Author(3, "George Orwell", Role.AUTHOR);
        Author author4 = new Author(4, "J.K. Rowling", Role.AUTHOR);
        Author author5 = new Author(5, "Agatha Christie", Role.AUTHOR);
        Author author6 = new Author(6, "Jane Austen", Role.AUTHOR);
        Author author7 = new Author(7, "J.R.R. Tolkien", Role.AUTHOR);
        Author author8 = new Author(8, "Leo Tolstoy", Role.AUTHOR);
        Author author9 = new Author(9, "Stephen King", Role.AUTHOR);
        Author author10 = new Author(10, "Mark Twain", Role.AUTHOR);

        author1.newBook(book1);
        author2.newBook(book2);
        author3.newBook(book3);
        author4.newBook(book4);
        author5.newBook(book5);
        author6.newBook(book6);
        author7.newBook(book7);
        author8.newBook(book8);
        author9.newBook(book9);
        author10.newBook(book10);

        Set<Book> borrowedBooks1 = new HashSet<>();
        Set<Book> borrowedBooks2 = new HashSet<>();
        Set<Book> borrowedBooks3 = new HashSet<>();

        Reader reader1 = new Reader(1, "Alice Norton", Role.USER, 0.0, borrowedBooks1, 5);
        Reader reader2 = new Reader(2, "Bob Newman", Role.USER, 75.49, borrowedBooks2, 3);
        Reader reader3 = new Reader(3, "Charlie Halpert", Role.USER, 113.98, borrowedBooks3, 2);

        librarian.issueBook(reader1, book1, library);
        librarian.issueBook(reader1, book2, library);
        librarian.issueBook(reader2, book3, library);

        library.showBooks();

        reader1.showBook();

        Invoice invoice = new Invoice(reader1, 35.98);
        System.out.println(invoice);

        double fine = librarian.calculateFine(reader2, book4);
        System.out.println("Fine for " + reader2.getName() + ": $" + fine);
    }
}