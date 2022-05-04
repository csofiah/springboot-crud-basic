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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class PersonServiceImpl implements PersonaService {

    private final PersonRepository personRepository;

    public PersonDto addPerson(PersonDto personDto) throws PersonException {
        try {
            //validate for type identification

            return PersonMapper.createDtoFromEntity(personRepository.save(PersonMapper.createEntityFromDto(personDto)));
        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_INSERT_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error al insertar Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    public List<PersonDto> getAllPerson() {
        try {
            return personRepository.findAll().stream()
                    .map(PersonMapper::createDtoFromEntity)
                    .collect(Collectors.toList());

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
                //validar si la persona existe
            //si existe esa misma person setearle los datos de la nueva persona y mandarla a guardar en el repo
            //sino existe lanzar una exception
            Optional<Person> oldPersonOptional = personRepository.findById(id);
            if(oldPersonOptional.isPresent()){
                PersonDto newPersonToUpdate = newPerson.toBuilder()
                        .id(id)
                        .build();
                Person newEntity = PersonMapper.createEntityFromDto(newPersonToUpdate);
                return PersonMapper.createDtoFromEntity(personRepository.save(newEntity));
            }else{
                log.error("No se encontro la persona con id {}", id);
                throw PersonException.Type.ERROR_UPDATE_PERSON.build();
            }

        } catch (PersonException ex) {
            throw PersonException.Type.ERROR_UPDATE_PERSON.build(ex);
        } catch (Exception ex) {
            log.error("Error actualizar Persona {}", ex.getMessage());
            throw BusinessException.Type.ERROR_GENERAL_BUSINESS.build(ex);
        }
    }


    //return oldPersonOptional.isPresent() ? createNewPersonAndUpdate(newPerson) : throwException(id);
           /* return personRepository.findById(id)
                    .map(newPerson2 ->   this.createNewPersonAndUpdate(newPerson)).get();*/
}
