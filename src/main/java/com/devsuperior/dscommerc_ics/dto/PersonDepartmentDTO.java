package com.devsuperior.dscommerc_ics.dto;

import java.util.Objects;

import com.devsuperior.dscommerc_ics.entities.Person;

public class PersonDepartmentDTO {
	
	
	private Long id;
	private String name;
	private Double salary;
	
	private DepartmentDTO department;

	public PersonDepartmentDTO(Long id, String name, Double salary, DepartmentDTO department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public PersonDepartmentDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		salary = entity.getSalary();
		
        department = new DepartmentDTO(entity.getDepartment());
	
	
	}

	public PersonDepartmentDTO() {
		
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

	public DepartmentDTO getDepartment() {
		return department;
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
		PersonDepartmentDTO other = (PersonDepartmentDTO) obj;
		return Objects.equals(id, other.id);
	}


	
	
	
	
	
	
	
	

}
