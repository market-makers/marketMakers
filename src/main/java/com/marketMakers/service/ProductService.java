package com.marketMakers.service;

import com.marketMakers.dto.Category;
import com.marketMakers.model.Product;
import com.marketMakers.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findAllLimit(int quantity) {
        List<?> object = repository.findAllLimit(quantity);
        List<Product> result = new ArrayList<>();
        for (Object obj : object) {
            Object[] o = (Object[]) obj;
            Product prod = new Product();
            prod.setName(String.valueOf(o[0]));
            prod.setAveragePrice((String.valueOf(o[1])));
            prod.setAmount(Integer.parseInt(String.valueOf(o[2])));
            result.add(prod);
        }
        return result;
    }

	public List<Product> findAllMissingLimit(int quantity) {
		List<?> object = repository.findAllRandom(quantity);
		List<Product> result = new ArrayList<>();
		for (Object obj : object) {
			Object[] o = (Object[]) obj;
			Product prod = new Product();
			prod.setName(String.valueOf(o[0]));
			prod.setAveragePrice((String.valueOf(o[1])));
			prod.setAmount(Integer.parseInt(String.valueOf(o[2])));
			result.add(prod);
		}
		return result;
	}

	public List<Category> findAllCategoryLimit(int quantity) {
		List<?> object = repository.findAllCategoryLimit(quantity);
		List<Category> result = new ArrayList<>();
		for (Object obj : object) {
			Object[] o = (Object[]) obj;
			Category cat = new Category();
			cat.setName(String.valueOf(o[0]));
			cat.setAveragePrice((String.valueOf(o[1])));
			cat.setAmount(Integer.parseInt(String.valueOf(o[2])));
			result.add(cat);
		}
		return result;
	}

    public Product save(Product product) {
        return repository.save(product);
    }
}