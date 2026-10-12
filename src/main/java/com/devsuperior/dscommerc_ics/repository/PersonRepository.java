package com.devsuperior.dscommerc_ics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dscommerc_ics.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
