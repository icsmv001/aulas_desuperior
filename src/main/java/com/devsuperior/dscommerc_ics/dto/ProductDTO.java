package com.devsuperior.dscommerc_ics.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.devsuperior.dscommerc_ics.entities.Category;
import com.devsuperior.dscommerc_ics.entities.Product;

public class ProductDTO {
	
	
	private Long id;
	private String name;
	private Double price;
	
	
	private List<CategoryDTO> categories = new ArrayList<>();


	

	public ProductDTO(Long id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		price = entity.getPrice();
		
		
		for (Category cat : entity.getCategories()) {
			
			categories.add(new CategoryDTO(cat));
			
			
			
			
		}
		
		
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
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
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(id, other.id);
	}


	public List<CategoryDTO> getCategories() {
	    return categories;
	}

	   // Construtor padrão exigido para desserialização
    public ProductDTO() {
    }

	

}
