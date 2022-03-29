package com.company.springbootcrudbasic.controller;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.exception.PersonException;
import com.company.springbootcrudbasic.service.PersonService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("api/person")
public class PersonRestController {

   private final PersonService personService;

   @PostMapping
    public PersonDto addPerson(@RequestBody PersonDto personDto){
       try {
           log.info("add person");
           return personService.addPerson(personDto);
       }catch(PersonException ex){
           log.error("error en PersonRestController, addPerson {}", ex.getMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error creando persona");
       }catch (Exception e){
           throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error del servidor, contacte al administrador");
       }
   }
}
