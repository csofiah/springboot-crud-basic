package com.company.springbootcrudbasic.model;

import lombok.*;

public class LineInvoice {
    private int number;
    private String description;
    private double amount;

    public LineInvoice(int number, String description, double amount) {
        this.number = number;
        this.description = description;
        this.amount = amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
