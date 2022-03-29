package com.company.springbootcrudbasic.service;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.exception.PersonException;
import com.company.springbootcrudbasic.exception.PersonException2;
import com.company.springbootcrudbasic.mapper.PersonMapper;
import com.company.springbootcrudbasic.model.Person;
import com.company.springbootcrudbasic.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonDto personDto;
    private static String METHOD_NAME;

    public PersonDto addPerson(PersonDto personDto) throws PersonException {
        try{
            METHOD_NAME = "adPerson";
            Person newPerson = PersonMapper.createEntityFromDto(personDto);
            return PersonMapper.createDtoFromEntity(personRepository.save(newPerson));
        }catch(Exception ex){
            PersonException2 exp = new PersonException2(METHOD_NAME, ex);
            log.error("Error al insertar Persona {}", exp.getMessage());
            throw  exp;
            //throw PersonException.Type.ERROR_INSERT_PERSON.build();

        }
    }

}
