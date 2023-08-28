package com.workintech.library.model;

import com.workintech.library.helper.Role;

import java.util.HashSet;
import java.util.Set;

public class Reader extends Person {

    private double billAmount;
    private Set<Book> borrowedBooks;
    private int bookLimit;

    public Reader(int id, String name, Role role, double billAmount, Set<Book> borrowedBooks, int bookLimit) {
        super(id, name, role);
        this.billAmount = billAmount;
        this.borrowedBooks = borrowedBooks;
        this.bookLimit = bookLimit;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBookLimit() {
        return bookLimit;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public void setBorrowedBooks(Set<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public void setBookLimit(int bookLimit) {
        this.bookLimit = bookLimit;
    }

    public void purchaseBook(Book book) {
        double bookPrice =  book.getPrice();

        if (bookPrice <= 0) {
            System.out.println("The book " + book.getTitle() + " is not available for purchase.");
            return;
        }

        if (getBillAmount() >= bookPrice) {
            setBillAmount(getBillAmount() - bookPrice);

            System.out.println(getName() + " has purchased the book " + book.getTitle());
        } else {
            System.out.println(getName() + " doesn't have enough balance to purchase the book " + book.getTitle());
        }
    }

    public void borrowBook(Book book) {
        if (borrowedBooks.size() < bookLimit) {
            borrowedBooks.add(book);
            book.setStatus("Borrowed");
            System.out.println(getName() + " has borrowed the book " + book.getTitle());
        } else {
            System.out.println(getName() + " has reached the book limit and cannot borrow more books.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.setStatus("Available");
            System.out.println(getName() + " has returned the book " + book.getTitle());
        } else {
            System.out.println(getName() + " did not borrow the book " + book.getTitle());
        }
    }

    public void showBook() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(getName() + " has not borrowed any books.");
            return;
        }

        System.out.println(getName() + "'s borrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }

    @Override
    public Role whoYouAre() {
        return Role.USER;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------READER--------\n");
        builder.append("User ID: " + super.getId() + "\n");
        builder.append("Name: " + super.getName() + "\n");
        builder.append("Borrowed Books: \n" + getBorrowedBooks() + "\n");
        return builder.toString();
    }
}
