package com.company.springbootcrudbasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fistName;
    private String middleName;
    private String lastName;
    private String typeIdentification;
    private int numberIdentification;
    private String typePerson;
    private String companyName;
    private String companyFoundationYear;
}
