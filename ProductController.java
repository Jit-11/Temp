package com.project.controller;

import java.util.List;

import com.project.Dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.model.Product;
import com.project.service.ProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
    @Autowired
    private UserDao userDao;

	@PostMapping(value = {"/add"})
	public String productAdd(@RequestBody Product product) {
		productService.add(product);
		return "success";
	}

	@GetMapping("/user/{userId}")
	public List<Product> getProductsByUser(@PathVariable int userId) {
		return productService.getProductsByUser(userId);
	}

	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping(value = {"/update"})
	public String productUpdate(@RequestBody Product product) {
		productService.modify(product);
		return "success";
	}

	
	@DeleteMapping(value = {"/delete/{id}"})
	public String productDelete1(@PathVariable int id) {
		System.out.println("product  deleted");
		productService.removeById(id);
		return "success";
	}
	
	@GetMapping(value = {"/{id}"})
	public Product productGet(@PathVariable int id) {
		return productService.getById(id);
	}
	
	@GetMapping(value = {""})
	public List<Product> productList(){
		return productService.getAll();
	}
	
	@GetMapping(value = {"/byname/{name}"})
	public List<Product> productListByName(@PathVariable String name){
		return productService.getAllByName(name);
	}



	@GetMapping(value = {"/byCategory/{category}"})
	public List<Product> productListBySalary(@PathVariable String category){
		return productService.getByCategory(category);
	}
	
}
