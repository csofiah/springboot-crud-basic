package com.company.springbootcrudbasic.controller;

import com.company.springbootcrudbasic.model.Invoice;
import com.company.springbootcrudbasic.model.LineInvoice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    static List<Invoice> invoices = new ArrayList<Invoice>();

    static{
        Invoice f1 = new Invoice(1, "informatica");
        LineInvoice li1 = new LineInvoice(1,"auricular", 200);
        LineInvoice li2 = new LineInvoice(2,"telefono", 300);
        List<LineInvoice> lineInvoices1 = List.of(li1, li2);
        f1.setLines(lineInvoices1);

        Invoice f2 = new Invoice(2, "alimentacion");
        LineInvoice li21 = new LineInvoice(1,"galletas", 2);
        LineInvoice li22 = new LineInvoice(1,"leche", 1);
        List<LineInvoice> lineInvoices2 = List.of(li21, li22);
        f2.setLines(lineInvoices2);

        Invoice f3 = new Invoice(3, "limpieza");
        LineInvoice li31 = new LineInvoice(1,"gel", 2);
        LineInvoice li32 = new LineInvoice(2,"jabon", 4);
        List<LineInvoice> lineInvoices3 = List.of(li31, li32);
        f3.setLines(lineInvoices3);

        //lista de facturas
        invoices.add(f1);
        invoices.add(f2);
        invoices.add(f3);
    }

    @RequestMapping
    public List<Invoice> findInvoices(){
        return invoices;
    }

    //example localhost:8080/invoices/1
    @RequestMapping("{number}")
    public Optional<Invoice> findOne(@PathVariable int number){
        return invoices.stream()
                .filter(f -> f.getNumber()==number)
                .findFirst();
    }

    //example localhost:8080/invoices/1/lines/2
    @RequestMapping("{number}/lines/{numberline}")
    public Optional<LineInvoice> findOneLineInvoice(@PathVariable int number, @PathVariable int numberline){
        Optional<Invoice> invoice = invoices.stream()
                .filter(f -> f.getNumber()==number)
                .findFirst();

        if(invoice.isPresent()){
            return invoice.get()
                    .getLines().stream()
                               .filter(f -> f.getNumber()==numberline)
                               .findFirst();
        }
        return Optional.empty();
    }
}
