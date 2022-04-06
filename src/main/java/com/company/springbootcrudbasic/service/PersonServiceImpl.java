package com.company.springbootcrudbasic.service;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.exception.BusinessException;
import com.company.springbootcrudbasic.exception.PersonException;
import com.company.springbootcrudbasic.mapper.PersonMapper;
import com.company.springbootcrudbasic.model.Person;
import com.company.springbootcrudbasic.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonaService {

    private final PersonRepository personRepository;

    //MapStruct
    public PersonDto addPerson(PersonDto personDto) throws PersonException {
        try {
            //validate for type identification
            Person newPerson = PersonMapper.createEntityFromDto(personDto);
            return PersonMapper.createDtoFromEntity(personRepository.save(newPerson));
        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_INSERT_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error al insertar Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    public List<PersonDto> getAllPerson() {
        try {
            log.info("listando persons");
            List<Person> personList = new ArrayList<>();
            Iterable<Person> iter = personRepository.findAll(); //stream
            iter.forEach(personList::add);

            return PersonMapper.createListDtoFromEntity(personList);
        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_GET_LIST_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error al listar Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    public PersonDto getPersonById(long id) {
        try {
            log.info("buscando person id {}", id);
            return PersonMapper.createDtoFromEntity(personRepository.findById(id).orElseGet(null));
        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_NOT_FOUND_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error al obteniendo Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    public int deletePersonById(long id) {
        try {
            log.info("Eliminando person id {}", id);
            personRepository.deleteById(id);
            return 1;
        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_DELETE_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error al obteniendo Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    public PersonDto updatePerson(long id, PersonDto newPerson) {
        try {
            Person oldPerson = personRepository.findById(id).orElse(null);
            log.info("update person id {}", id);//optional stream
            if (oldPerson != null) {
                Person newEntity = PersonMapper.createEntityFromDto(newPerson);
                return PersonMapper.createDtoFromEntity(personRepository.save(newEntity));
            } else {
                throw PersonException.Type.ERROR_NOT_FOUND_PERSON.build();
            }

        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_UPDATE_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error actualizar Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }

}
