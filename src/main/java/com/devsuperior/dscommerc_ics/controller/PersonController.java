package com.devsuperior.dscommerc_ics.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dscommerc_ics.dto.PersonDepartmentDTO;
import com.devsuperior.dscommerc_ics.service.PersonService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value= "/people")
public class PersonController {

@Autowired
private PersonService service;

	@PostMapping
	public ResponseEntity<PersonDepartmentDTO> insert(@Valid  @RequestBody  PersonDepartmentDTO dto) {
		 dto =  service.insert(dto);
		 
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        		 .buildAndExpand(dto.getId()).toUri();
         return ResponseEntity.created(uri).body(dto);
	}
	
	
	
	
	
	
	
	
}
