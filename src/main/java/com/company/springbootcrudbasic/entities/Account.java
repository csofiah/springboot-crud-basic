package com.company.springbootcrudbasic.entities;

import com.company.springbootcrudbasic.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "account_type")
    private String type;

    @Column(name = "account_number")
    private int accountNumber;

    @Column(name = "currency")
    private String currency;

    @Column(name = "balance")
    private long balance;

    @ManyToOne
    @JoinColumn(name = "id_person")
    private Person person;
}
