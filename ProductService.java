package com.project.service;

import java.util.List;

import com.project.model.Product;

public interface ProductService {
	void add(Product product);
	void modify(Product product);
	void removeById(int id);
	Product getById(int id);
	List<Product> getAll();
	List<Product> getAllByName(String name);
	List<Product> getByCategory(String category);

    List<Product> getProductsByUser(int userId);

	List<Product> getAllProducts();

	Product saveProduct(Product product);
}
