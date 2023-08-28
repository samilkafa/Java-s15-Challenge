package com.workintech.library.model;

import java.time.LocalDate;

public class Invoice {
    private static int invoiceCounter = 1;
    private int invoiceID;
    private LocalDate issueDate;
    private double amount;
    private Reader customer;

    public Invoice(Reader customer, double amount) {
        this.invoiceID = invoiceCounter++;
        this.issueDate = LocalDate.now();
        this.amount = amount;
        this.customer = customer;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public double getAmount() {
        return amount;
    }

    public Reader getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("--------INVOICE--------\n");
        builder.append("Invoice ID: " + getInvoiceID() + "\n");
        builder.append("Issue Date: " + getIssueDate() + "\n");
        builder.append("Amount: " + getAmount() + "\n");
        builder.append("Customer: \n" + getCustomer() + "\n");
        return builder.toString();
    }
}
