package com.devsuperior.dscommerc_ics.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dscommerc_ics.dto.CategoryDTO;
import com.devsuperior.dscommerc_ics.dto.ProductDTO;
import com.devsuperior.dscommerc_ics.entities.Category;
import com.devsuperior.dscommerc_ics.entities.Product;
import com.devsuperior.dscommerc_ics.repository.CategoryRepository;
import com.devsuperior.dscommerc_ics.repository.ProductRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
	
@Autowired	
private ProductRepository repository;

@Autowired 
private CategoryRepository categoryReporitory;


@Transactional
public ProductDTO insert(ProductDTO dto) {
	
	
	Product entity = new Product();
	
	entity.setName(dto.getName());
	entity.setPrice(dto.getPrice());
	
	//criar as categorias, alinhadas origim da lista de categoria
	// user um for
	
	for(CategoryDTO catDto : dto.getCategories()) {
		
		Category cat = categoryReporitory.getReferenceById(catDto.getId());
		//Category cat = new Category();
		//cat.setId(catDto.getId());
		//cat.setName(catDto.getName());
		entity.getCategories().add(cat);
	}
	
	
	entity = repository.save(entity);
	return new ProductDTO(entity);
	
	
	
	
}
	

}
