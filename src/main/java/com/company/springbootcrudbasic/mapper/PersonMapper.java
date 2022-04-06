package com.company.springbootcrudbasic.mapper;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonMapper {

    public static PersonDto createDtoFromEntity(Person person){
        PersonDto personDto = PersonDto.builder().build();
        if(person != null){
            personDto.toBuilder()
                    .id(person.getId())
                    .fistName(person.getFistName())
                    .middleName(person.getMiddleName())
                    .lastName(person.getLastName())
                    .typeIdentification(person.getTypeIdentification())
                    .numberIdentification(person.getNumberIdentification())
                    .typePerson(person.getTypePerson())
                    .companyName(getCompanyName(person))
                    .foundationDate(getFoundationDate(person))
                    .build();
       }
        return personDto;

    }

    public static Person createEntityFromDto(PersonDto personDto){
        Person person = Person.builder().build();
        if(personDto!=null){
            person.toBuilder()
                    .id(personDto.getId())
                    .fistName(personDto.getFistName())
                    .middleName(personDto.getMiddleName())
                    .lastName(personDto.getLastName())
                    .typeIdentification(personDto.getTypeIdentification())
                    .numberIdentification(personDto.getNumberIdentification())
                    .typePerson(personDto.getTypePerson())
                    .companyName(personDto.getCompanyName())
                    .foundationDate(personDto.getFoundationDate())
                    .build();
        }
        return person;
    }

    public static List<PersonDto> createListDtoFromEntity(List<Person> persons) {
        List<PersonDto> personDtos = new ArrayList<PersonDto>();//optional, stream
        if (persons != null) {
            for (Person person : persons) {
                personDtos.add(createDtoFromEntity(person));
            }
        }
        return personDtos;
    }
    
    public static String getCompanyName(Person person){
        String company ="";
        if(person.getCompanyName()!=null){
            company= person.getCompanyName();
        }
          return company;
    }

    public static Date getFoundationDate(Person person){
        Date foundationDate = null;
        if(person.getFoundationDate()!=null){
            foundationDate= person.getFoundationDate();
        }
        return foundationDate;
    }
}
