package com.marketMakers.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.marketMakers.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	@Query
	(value = "SELECT product.name, AVG(product.value), SUM(Quantity) as total FROM product  GROUP by code ORDER by total desc limit :quantity", nativeQuery = true)
	List<?> findAllLimit(@Param("quantity") int quantity);
}