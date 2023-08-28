package com.workintech.library.model;

import com.workintech.library.helper.Genre;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

    private int bookID;
    private String author;
    private String title;
    private double price;
    private String status;
    private int edition;
    private String  dateOfPurchase;
    private Genre genre;

    public Book(int bookID, String author, String title, double price, String status, int edition, String dateOfPurchase, Genre genre) {
        this.bookID = bookID;
        this.author = author;
        this.title = title;
        this.price = price;
        this.status = status;
        this.edition = edition;
        this.dateOfPurchase = dateOfPurchase;
        this.genre = genre;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setCategory(Genre category) {
        this.genre = genre;
    }

    public String getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------BOOK--------\n");
        builder.append("Book ID: " + getBookID() + "\n");
        builder.append("Author: " + getAuthor() + "\n");
        builder.append("Title: " + getTitle() + "\n");
        builder.append("Price: " + getPrice() + "\n");
        builder.append("Status : " + getStatus() + "\n");
        builder.append("Edition : " + getEdition() + "\n");
        builder.append("Genre : " + getGenre() + "\n");
        builder.append("Date of Purchase : " + getDateOfPurchase() + "\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookID == book.bookID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookID);
    }
}
