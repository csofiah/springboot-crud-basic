//package com.company.springbootcrudbasic.service;
//
//import com.company.springbootcrudbasic.dto.PersonDto;
//import com.company.springbootcrudbasic.mocks.PersonDtoMock;
//import com.company.springbootcrudbasic.repository.PersonRepository;
//import lombok.var;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//class PersonServiceImplTest {
//
//    private PersonRepository personRepository;
//    private PersonServiceImpl underTest;
//
//    @BeforeEach
//    void setUp() {
//        personRepository = Mockito.mock(PersonRepository.class);
//        underTest = new PersonServiceImpl(personRepository);
//    }
//
//    @DisplayName("addPerson when personDto has all data, then it's successful")
//    @Test
//    void addPerson() {
//        when(personRepository.save())
//        PersonDto newNaturalPersonDto = PersonDtoMock.getPersonDtoNaturalCompleted();
//        var result = underTest.addPerson(newNaturalPersonDto);
//    }
//
//    @Test
//    void getAllPerson() {
//    }
//
//    @Test
//    void getPersonById() {
//    }
//
//    @Test
//    void deletePersonById() {
//    }
//
//    @Test
//    void updatePerson() {
//    }
//}