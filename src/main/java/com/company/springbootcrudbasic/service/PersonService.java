package com.company.springbootcrudbasic.service;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.exception.PersonException;
import com.company.springbootcrudbasic.exception.PersonException2;
import com.company.springbootcrudbasic.mapper.PersonMapper;
import com.company.springbootcrudbasic.model.Person;
import com.company.springbootcrudbasic.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final PersonDto personDto;
    private static String METHOD_NAME;

    public PersonDto addPerson(PersonDto personDto) throws PersonException {
        try {
            METHOD_NAME = "addPerson";
            Person newPerson = PersonMapper.createEntityFromDto(personDto);
            return PersonMapper.createDtoFromEntity(personRepository.save(newPerson));
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en agregar personas");
        } catch (Exception ex) {
            //TODO revisar como enviarle el detalle de la exception
            PersonException2 exp = new PersonException2(METHOD_NAME, ex);
           // throw PersonException.Type.ERROR_INSERT_PERSON.build();
            log.error("Error al insertar Persona {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, METHOD_NAME + " Error en servidor al agregar personas");
        }
    }

    @GetMapping
    public List<PersonDto> getAllPerson() {
        try {
            METHOD_NAME = "getAllPerson";
            log.info("listando persons");
            List<Person> personList = new ArrayList<>();
            Iterable<Person> iter = personRepository.findAll();
            iter.forEach(personList::add);

            return PersonMapper.createListDtoFromEntity(personList);
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en proceso de listar personas");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, METHOD_NAME + " Error en servidor al listar personas");
        }
    }

    @GetMapping(path = "{id}")
    public PersonDto getPersonById(@PathVariable("id") long id) {
        try {
            METHOD_NAME = "getPersonById";
            log.info("buscando person id {}", id);
            //TODO si se quiere lanzar excepcion en caso q no encuentre la persona
            // como se hace para q lanece a excepcion
            //return PersonMapper.createDtoFromEntity(personRepository.findById(id).orElseThrow(PersonException.Type.ERROR_INSERT_PERSON.build()));
            return PersonMapper.createDtoFromEntity(personRepository.findById(id).orElseGet(null));
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error en proceso de busqueda persona");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, METHOD_NAME + " Error en servidor buscar persona");
        }
    }

    @DeleteMapping(path = "{id}")
    public int deletePersonById(@PathVariable("id") long id) {
        try {
            METHOD_NAME = "deletePersonById";
            log.info("Eliminando person id {}", id);
            PersonDto deletePersonDto = this.getPersonById(id);
            Person personToDelete = PersonMapper.createEntityFromDto(personDto);
            personRepository.delete(personToDelete);
            return 1;
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en proceso de eliminar persona");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, METHOD_NAME + " Error en servidor eliminar persona");
        }
    }

    @PutMapping(path = "{id}")
    public PersonDto updatePerson(@PathVariable("id") long id, @RequestBody PersonDto newPerson) {
        try {
            METHOD_NAME = "updatePerson";
            Person oldPerson = personRepository.findById(id).orElse(null);
            log.info("update person id {}", id);
            if (oldPerson != null) {
                Person newEntity = PersonMapper.createEntityFromDto(newPerson);
                newEntity.setId(oldPerson.getId());
                return PersonMapper.createDtoFromEntity(personRepository.save(newEntity));
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro la persona que se quiere actualizar");
            }

        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en proceso de actualizar persona");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error en servidor actualizar persona");
        }
    }

}
