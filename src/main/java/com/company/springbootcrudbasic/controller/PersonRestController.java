package com.company.springbootcrudbasic.controller;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.exception.PersonException;
import com.company.springbootcrudbasic.service.PersonaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/person")
public class PersonRestController {

    private final PersonaService personService;

    @PostMapping
    public PersonDto addPerson(@RequestBody PersonDto personDto) {
        try {
            log.info("Agregar persona");
            return personService.addPerson(personDto);
        } catch (PersonException ex) {
            log.error("error en PersonRestController, addPerson {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creando persona");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor, contacte al administrador");
        }
    }

    @GetMapping(path = "/{id}")
    public PersonDto getPersonById(@PathVariable long id) {
        try {
            log.info("Buscando persona");
            return personService.getPersonById(id);
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error buscando persona");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor, contacte al administrador");
        }
    }

    @DeleteMapping(path = "/{id}")
    public int deletePersonById(@PathVariable("id") long id) {
        try {
            log.info("Eliminar persona");
            return personService.deletePersonById(id);
        } catch (PersonException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "error en borrar persona");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor, contacte al administrador");
        }
    }

    @PutMapping(path = "/{id}")
    public PersonDto updatePerson(@PathVariable("id") long id, @RequestBody PersonDto newUser) {
        try {
            log.info("Actualizando usuario");
            return personService.updatePerson(id, newUser);
        } catch (PersonException cex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en proceso de actualizar persona");
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Se ha presentado un problema");
        }
    }
}
