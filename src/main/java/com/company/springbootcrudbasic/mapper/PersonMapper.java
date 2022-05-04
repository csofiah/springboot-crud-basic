package com.company.springbootcrudbasic.mapper;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.model.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PersonMapper {

    private PersonMapper() {
    }

    public static PersonDto createDtoFromEntity(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        PersonDto personDto = PersonDto.builder().build();
        return optionalPerson.isPresent() ? getPersonDtoFromPerson(optionalPerson.get(), personDto) : personDto;
    }

    private static PersonDto getPersonDtoFromPerson(Person person, PersonDto personDto) {
        return personDto.toBuilder()
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

    public static Person createEntityFromDto(PersonDto personDto) {
     // arreglar
        return null;
       /* Optional<PersonDto> optionalPersonDto = Optional.ofNullable(personDto);
        Person person = Person.builder().build();
        return optionalPersonDto.isPresent() ? getPersonFromDto(optionalPersonDto.get(), person) : person;*/
    }

    //
    private static Person mapDtoToModel(PersonDto personDto) {
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

    //TODO este metodo lo deje solo para ejemplo porque ya no lo uso
    public static List<PersonDto> createListDtoFromEntity(List<Person> persons) {
        Optional<List<Person>> optionalListPerson = Optional.ofNullable(persons);
        List<PersonDto> listPersonDto = new ArrayList<>();

        //optionalListPerson.isPresent() ? listPersonDto : getListPersonDto(optionalListPerson.get());
        return optionalListPerson.map(people -> listPersonDto).orElseGet(() -> getListPersonDto(optionalListPerson.get()));
    }

    private static List<PersonDto> getListPersonDto(List<Person> listPerson) {
        return listPerson.stream()
                .map(PersonMapper::createDtoFromEntity)
                .collect(Collectors.toList());
    }

    public static String getCompanyName(Person person) {
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        return optionalPerson.isPresent() ? optionalPerson.get().getCompanyName() : "";
    }

    public static Date getFoundationDate(Person person) {

        //optional usar orElse para colocar el valor por defecto
        Optional<Person> optionalPerson = Optional.ofNullable(person);
        //optionalPerson.isPresent() ? optionalPerson.get().getFoundationDate() : null;
        return optionalPerson.map(Person::getFoundationDate).orElse(null);
    }
}
