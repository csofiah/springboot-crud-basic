package com.company.springbootcrudbasic.repository;

import com.company.springbootcrudbasic.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
