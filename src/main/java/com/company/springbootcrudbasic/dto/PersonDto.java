package com.company.springbootcrudbasic.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Builder(toBuilder = true)
@Getter
@Setter
public class PersonDto {

    private Long id;

    private String fistName;

    private String middleName;

    private String lastName;

    private String typeIdentification;

    private int numberIdentification;

    private String typePerson;

    private String companyName;

    private Date foundationDate;
}
