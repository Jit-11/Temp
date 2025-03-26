package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Dao.ProductDao;
import com.project.model.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public void add(Product product) {
		productDao.save(product);
	}

	@Override
	public void modify(Product product) {
		productDao.save(product);
	}

	@Override
	public void removeById(int id) {
		productDao.deleteById(id);
	}

	@Override
	public Product getById(int id) {
		Optional<Product> opt = productDao.findById(id);
		return opt.orElse(null);
	}

	@Override
	public List<Product> getAll() {
		List<Product> lst = new ArrayList<>();
		productDao.findAll().forEach(lst::add);
		return lst;
	}

	@Override
	public List<Product> getAllByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public List<Product> getByCategory(String category) {
		return productDao.selectByCategory(category);
	}

	@Override
	public List<Product> getProductsByUser(int userId) {
		return List.of();
	}

	@Override
	public List<Product> getAllProducts() {
		return List.of();
	}

	@Override
	public Product saveProduct(Product product) {
		return null;
	}
}
