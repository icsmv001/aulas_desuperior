package com.devsuperior.dscommerc_ics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dscommerc_ics.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
