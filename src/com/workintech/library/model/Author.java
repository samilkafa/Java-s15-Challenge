package com.workintech.library.model;

import com.workintech.library.helper.Role;

import java.util.ArrayList;
import java.util.List;

public class Author extends Person {

    private List<Book> booksAuthored;

    public Author(int id, String name, Role role) {
        super(id, name, role);
        this.booksAuthored = new ArrayList<>();
    }

    public List<Book> getBooksAuthored() {
        return booksAuthored;
    }

    public void setBooksAuthored(List<Book> booksAuthored) {
        this.booksAuthored = booksAuthored;
    }

    public void newBook(Book book) {
        booksAuthored.add(book);
        System.out.println("New book added: " + book.getTitle());
    }

    public void showBooks() {
        for (Book book : booksAuthored) {
            System.out.println("- " + book.getTitle());
        }
    }

    @Override
    public Role whoYouAre() {
        return Role.AUTHOR;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------AUTHOR--------\n");
        builder.append("Author ID: " + super.getId());
        builder.append("Name: " + super.getName());
        builder.append("Books: " + getBooksAuthored());
        return builder.toString();
    }
}
