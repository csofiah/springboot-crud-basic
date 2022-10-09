package com.company.springbootcrudbasic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


public class Invoice {
    private int number;
    private String description;
    private List<LineInvoice> lines = new ArrayList<LineInvoice>();

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

    public List<LineInvoice> getLines() {
        return lines;
    }

    public void setLines(List<LineInvoice> lines) {
        this.lines = lines;
    }

    public Invoice(int number, String description) {
        this.number = number;
        this.description = description;
    }
}
