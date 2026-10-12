package com.devsuperior.dscommerc_ics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscommerc_ics.dto.PersonDepartmentDTO;
import com.devsuperior.dscommerc_ics.entities.Department;
import com.devsuperior.dscommerc_ics.entities.Person;
import com.devsuperior.dscommerc_ics.repository.DepartmentRepository;
import com.devsuperior.dscommerc_ics.repository.PersonRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
	

	@Autowired
	private PersonRepository repository;
	
	@Autowired	
	private DepartmentRepository departmentRepository;
	
	@Transactional
	
	public PersonDepartmentDTO insert (PersonDepartmentDTO dto) {
		
		Person entity = new Person();
		entity.setName(dto.getName());
		entity.setSalary(dto.getSalary());
		
		Department dept = departmentRepository.findById(dto.getDepartment().getId())
		        .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
		//Department dept = new Department();
		//dept.setId(dto.getDepartment().getId());
		
		entity.setDepartment(dept);
		entity = repository.save(entity);
		return new PersonDepartmentDTO(entity);
		
		
		
		
	}

}
