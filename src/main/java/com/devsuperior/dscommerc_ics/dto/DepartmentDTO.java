package com.devsuperior.dscommerc_ics.dto;

import java.util.Objects;

import com.devsuperior.dscommerc_ics.entities.Department;

public class DepartmentDTO {
	
	
	private Long id;
	private String name;
	
	public DepartmentDTO(Long id, String name) {
	    this.id = id;
		this.name = name;
	}

	
	public DepartmentDTO(Department entity) {
	    id = entity.getId();
		name = entity.getName();
	}
	
	
	public DepartmentDTO() {
		
	}
	
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
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
		DepartmentDTO other = (DepartmentDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	

	
	
}
