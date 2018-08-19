package com.marketMakers.service;

import com.marketMakers.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketMakers.repository.ProductRepository;

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

    public Product save(Product product) {
        return repository.save(product);
    }
}