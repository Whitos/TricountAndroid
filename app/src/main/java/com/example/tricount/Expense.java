package com.example.tricount;

import java.util.List;

public class Expense {
    private String title;
    private double amount;
    private String paidBy;
    private String date;

    public Expense(String title, double amount, String paidBy, String date) {
        this.title = title;
        this.amount = amount;
        this.paidBy = paidBy;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaidBy() {
        return paidBy;
    }

    public String getDate() {
        return date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaidBy(String paidBy) {
        this.paidBy = paidBy;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "title='" + title + '\'' +
                ", amount=" + amount +
                ", paidBy='" + paidBy + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}