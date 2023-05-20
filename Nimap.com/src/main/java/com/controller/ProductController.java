package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	@Autowired
	ProductService service;

	@GetMapping("/products")
	public List<Product> getAll() {
		return service.getAll();
	}

	@PostMapping("/products/{id}")
	public String addProduct(@RequestBody Product product, @PathVariable int id) {
		return service.addProduct(product, id);
	}

	@GetMapping("/products/{id}")
	public Product getByID(@PathVariable int id) {
		return service.getById(id);
	}

	@PutMapping("/products/{id}")
	public String updateProduct(@PathVariable int id, @RequestBody Product product) {
		return service.updateProduct(id, product);
	}

	@DeleteMapping("/products/{id}")
	public String deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
