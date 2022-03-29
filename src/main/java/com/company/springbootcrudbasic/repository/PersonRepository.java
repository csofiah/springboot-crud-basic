package com.company.springbootcrudbasic.repository;

import com.company.springbootcrudbasic.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
