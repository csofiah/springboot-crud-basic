package com.company.springbootcrudbasic.mapper;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.entities.Person;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonMapper {

    private PersonMapper() {
    }

    public static PersonDto mapToPersonDto(Person person) {
        return PersonDto.builder()
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

    public static Person mapToModel(PersonDto personDto) {
        return Person.builder()
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

    public static String getCompanyName(Person person) {
        return Optional.ofNullable(person.getCompanyName())
                .orElse("");
    }

    public static Date getFoundationDate(Person person) {
        return Optional.ofNullable(person.getFoundationDate())
                .orElse(null);
    }


    //TODO metodo de ejemplo
    private static List<PersonDto> getListPersonDto(List<Person> listPerson) {
        return listPerson.stream()
                .map(PersonMapper::mapToPersonDto)
                .collect(Collectors.toList());
    }
}
