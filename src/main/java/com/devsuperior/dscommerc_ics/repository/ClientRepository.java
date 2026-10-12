package com.devsuperior.dscommerc_ics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dscommerc_ics.entities.Client;



public interface ClientRepository extends JpaRepository <Client, Long>{
	
	
}
