package com.workintech.library.model;

import com.workintech.library.helper.Role;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Librarian extends Person {

    private String password;

    public Librarian(int id, String name, Role role, String password) {
        super(id, name, role);
        this.password = password;
    }

    public Book searchBook(String title, Library library) {
        List<Book> books = library.getBooks();

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean verifyMember(Reader reader) {
        return reader != null && reader.getRole() == Role.USER;
    }

    public void issueBook(Reader reader, Book book, Library library) {
        if (reader == null || reader.getRole() != Role.USER) {
            System.out.println("Invalid reader");
            return;
        }

        if (reader.getBorrowedBooks().size() >= reader.getBookLimit()) {
            System.out.println("Reader has reached the book limit and cannot borrow more books.");
            return;
        }

        if (!book.getStatus().equals("Available")) {
            System.out.println("The book is not available for borrowing.");
            return;
        }

        reader.borrowBook(book);
        library.lendBook(reader, book);
        System.out.println("Issued " + book.getTitle() + " to " + reader.getName());
    }

    private LocalDate calculateDueDate(Book book) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = currentDate.plusDays(14);

        while (dueDate.getDayOfWeek().getValue() > 5) {
            dueDate = dueDate.plusDays(1);
        }
        return dueDate;
    }

    private int calculateDaysLate(Reader reader, Book book) {
        LocalDate currentDate = LocalDate.now();
        LocalDate dueDate = calculateDueDate(book);
        long daysLate = ChronoUnit.DAYS.between(dueDate, currentDate);

        return (int) Math.max(daysLate, 0);
    }

    public double calculateFine(Reader reader, Book book) {
        int daysLate = calculateDaysLate(reader, book);
        double finerPerDay = 0.5;

        double fineAmount = daysLate * finerPerDay;
        return fineAmount;
    }

    public void createBill(Reader reader, double amount) {
        reader.setBillAmount(reader.getBillAmount() + amount);
        System.out.println("Created a bill of $" + amount + " for " + reader.getName());
    }

    public void returnBook(Book book, Reader reader, Library library) {
        if (book.getStatus().equals("Borrowed") && reader.getBorrowedBooks().contains(book)) {
            reader.returnBook(book);
            library.takeBackBook(book);
            System.out.println("Returned " + book.getTitle() + " from " + reader.getName());
        } else {
            System.out.println("Book not borrowed by the reader.");
        }
    }

    @Override
    public Role whoYouAre() {
        return Role.ADMIN;
    }
}
