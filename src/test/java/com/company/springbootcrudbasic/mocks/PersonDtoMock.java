package com.company.springbootcrudbasic.mocks;

import com.company.springbootcrudbasic.dto.PersonDto;
import lombok.val;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class PersonDtoMock {

    public static PersonDto getPersonDtoNaturalCompleted(){
        return PersonDto.builder()
                .id(123L)
                .fistName("Luis")
                .middleName("Alberto")
                .lastName("Ortiz")
                .typeIdentification("CC")
                .numberIdentification(1127564564)
                .typePerson("natural")
                .build();
    }

    public static PersonDto getPersonDtoLegalCompleted(){
        Date foundDate = new Date(2010, 1, 3);
        return PersonDto.builder()
                .id(123L)
                .fistName("Ana")
                .middleName("Maria")
                .lastName("Perez")
                .typeIdentification("RUT")
                .numberIdentification(456456)
                .typePerson("legal")
                .companyName("SoftCompany")
                .foundationDate(foundDate)
                .build();
    }


}
