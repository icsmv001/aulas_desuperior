package com.devsuperior.dscommerc_ics.dto;

import java.util.Objects;

import com.devsuperior.dscommerc_ics.entities.Person;

public class PersonDTO {
	
	
	
	
	
	
	private Long id;
	private String name;
	private Double salary;
	private Long departmentId;
	
	public PersonDTO(Long id, String name, Double salary, Long departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.departmentId = departmentId;
	}
	
	
	
	public PersonDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		salary = entity.getSalary();
        departmentId = entity.getDepartment().getId();
	}

	public PersonDTO() {
		
	}

	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public Double getSalary() {
		return salary;
	}



	public Long getDepartmentId() {
		return departmentId;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDTO other = (PersonDTO) obj;
		return Objects.equals(id, other.id);
	}

	
	
	
	
	
	
	
	
	
	

}
