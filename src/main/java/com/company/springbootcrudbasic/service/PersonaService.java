package com.company.springbootcrudbasic.service;

import com.company.springbootcrudbasic.dto.PersonDto;

import java.util.List;


public interface PersonaService {

    PersonDto addPerson(PersonDto personDto);

    List<PersonDto> getAllPerson();

    PersonDto getPersonById(long id);

    int deletePersonById(long id);

    PersonDto updatePerson(long id, PersonDto newPerson);
}
