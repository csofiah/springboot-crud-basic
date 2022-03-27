package com.company.springbootcrudbasic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "fist_name")
    private String fistName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "type_identification")
    private String typeIdentification;

    @Column(name = "number_identification")
    private int numberIdentification;

    @Column(name = "type_person")
    private String typePerson;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "foundation_date")
    private Date foundationDate;
}
